package com.app.apsfl.utils;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.format.Formatter;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.app.apsfl.R;
import com.app.apsfl.activities.PonChangeActivity;
import com.app.apsfl.interfaces.UserActionInterface;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Utils {

    private static ProgressDialog progressDialog = null;
    private static AlertDialog alertDialog;
    //private

    public static void showProgress(Context mContext, final String message) {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(mContext);
            progressDialog.setTitle(mContext.getString(R.string.progress_dialog_title));
            progressDialog.setMessage(message);
            progressDialog.setCancelable(false);
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();
        }
    }

    public static void cancelProgress() {
        if (progressDialog != null) {
            progressDialog.dismiss();
            progressDialog = null;
        }
    }

    public static void changeProgressMessage(String title, String message) {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.setTitle(title);
            progressDialog.setMessage(message);
        }
    }

    public static boolean isNetworkAvailable(final Context context) {
        ConnectivityManager manager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (manager != null) {
            NetworkInfo info = manager.getActiveNetworkInfo();
            //noinspection SimplifiableIfStatement
            if (info != null) {
                return info.isConnected();
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static String getIPAddress(final Context mContext) {
        WifiManager manager = (WifiManager) mContext.getSystemService(Context.WIFI_SERVICE);
        String ipAddress = "";
        if (manager.getConnectionInfo() != null) {
            ipAddress = Formatter.formatIpAddress(manager.getConnectionInfo().getIpAddress());
        }
        Log.d("IPAddress", "\t" + ipAddress);
        return ipAddress;
    }

    public static void showToast(final Context mContext,
                                 final String message) {
        Toast.makeText(mContext, message, Toast.LENGTH_LONG).show();
    }

    public static void showNoNetworkDialog(final Context mContext) {
        AlertDialog.Builder noNetworkDialog = new AlertDialog.Builder(mContext);
        noNetworkDialog.setTitle(mContext.getString(R.string.no_internet_title));
        noNetworkDialog.setMessage(mContext.getString(R.string.no_internet_message));
        noNetworkDialog.setPositiveButton(mContext.getString(R.string.open_settings), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mContext.startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
                alertDialog = null;
            }
        });
        noNetworkDialog.setNegativeButton(mContext.getString(R.string.alert_cancel), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                alertDialog = null;
            }
        });
        noNetworkDialog.setCancelable(false);
        if (alertDialog == null) {
            alertDialog = noNetworkDialog.create();
            alertDialog.show();
        }
    }

    public static void showNoGPSDialog(final Context mContext) {
        AlertDialog.Builder noNetworkDialog = new AlertDialog.Builder(mContext);
        noNetworkDialog.setTitle(mContext.getString(R.string.gps_not_enabled_title));
        noNetworkDialog.setMessage(mContext.getString(R.string.gps_not_enabled_message));
        noNetworkDialog.setPositiveButton(mContext.getString(R.string.open_location_settings), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mContext.startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                alertDialog = null;
            }
        });
        noNetworkDialog.setNegativeButton(mContext.getString(R.string.alert_cancel), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                alertDialog = null;
            }
        });
        noNetworkDialog.setCancelable(false);
        if (alertDialog == null) {
            alertDialog = noNetworkDialog.create();
            alertDialog.show();
        }
    }

    public static void showDialog(final Fragment fragment,
                                  final String title,
                                  final String message,
                                  final Integer actionType) {
        final Context mContext = fragment.getActivity();
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(mContext);
        dialogBuilder.setTitle(title);
        dialogBuilder.setMessage(message);
        dialogBuilder.setCancelable(false);
        dialogBuilder.setPositiveButton(mContext.getString(R.string.alert_ok), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                if (actionType != null) {
                    UserActionInterface listener = (UserActionInterface) fragment;
                    listener.onDialogConfirmed(actionType);
                }
            }
        });
        dialogBuilder.show();
    }

    public static void errorDialog(final Fragment fragment,
                                   final String title,
                                   final String message,
                                   final Integer actionType) {
        final Context mContext = fragment.getActivity();
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(mContext);
        dialogBuilder.setTitle(title);
        //dialogBuilder.setIcon(R.drawable.network_error_2);
        dialogBuilder.setMessage(message);
        dialogBuilder.setCancelable(false);
        dialogBuilder.setPositiveButton(mContext.getString(R.string.alert_ok), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                if (actionType != null) {
                    UserActionInterface listener = (UserActionInterface) fragment;
                    listener.onDialogConfirmed(actionType);
                }
            }
        });
        dialogBuilder.show();
    }

    public static void showDialog(final Context mContext,
                                  final String title,
                                  final String message,
                                  final Integer actionType) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(mContext);
        dialogBuilder.setTitle(title);
        dialogBuilder.setMessage(message);
        dialogBuilder.setCancelable(false);
        dialogBuilder.setPositiveButton(mContext.getString(R.string.alert_ok), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                if (actionType != null) {
                    UserActionInterface listener = (UserActionInterface) mContext;
                    listener.onDialogConfirmed(actionType);
                }
            }
        });
        dialogBuilder.show();
    }

    public static void showPonUpdateDialog(final Activity mContext,
                                           final String title,
                                           final String message,
                                           final Integer actionType) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(mContext);
        dialogBuilder.setTitle(title);
        dialogBuilder.setMessage(message);
        dialogBuilder.setCancelable(false);
        dialogBuilder.setPositiveButton(mContext.getString(R.string.alert_ok), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //dialog.dismiss();
                mContext.finish();
                PonChangeActivity.caf_number.setText("");
                PonChangeActivity.caf_details_visibility.setVisibility(View.GONE);
                if (actionType != null) {
                    UserActionInterface listener = (UserActionInterface) mContext;
                    listener.onDialogConfirmed(actionType);
                }
            }
        });
        dialogBuilder.show();
    }

    public static void showPonAddressUpdateDialog(final Activity mContext,
                                                  final String title,
                                                  final String message,
                                                  final Integer actionType) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(mContext);
        dialogBuilder.setTitle(title);
        dialogBuilder.setMessage(message);
        dialogBuilder.setCancelable(false);
        dialogBuilder.setPositiveButton(mContext.getString(R.string.alert_ok), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //dialog.dismiss();
                mContext.finish();
                PonChangeActivity.caf_number.setText("");
                PonChangeActivity.caf_details_visibility.setVisibility(View.GONE);
                if (actionType != null) {
                    UserActionInterface listener = (UserActionInterface) mContext;
                    listener.onDialogConfirmed(actionType);
                }
            }
        });
        dialogBuilder.show();
    }

    public static void showCafErrorDialog(final Context mContext,
                                          final String title,
                                          final String message,
                                          final Integer actionType) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(mContext);
        dialogBuilder.setTitle(title);
        dialogBuilder.setMessage(message);
        dialogBuilder.setCancelable(false);
        dialogBuilder.setPositiveButton(mContext.getString(R.string.alert_ok), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        dialogBuilder.show();
    }

    public static void showUserConfirmationDialog(final Context mContext,
                                                  final Fragment fragment,
                                                  final String message,
                                                  final int actionType) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(mContext);
        dialogBuilder.setTitle(mContext.getString(R.string.confirm_action_title));
        dialogBuilder.setMessage(message);
        dialogBuilder.setCancelable(false);
        dialogBuilder.setPositiveButton(mContext.getString(R.string.alert_ok), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                UserActionInterface listener;
                if (fragment == null) {
                    listener = (UserActionInterface) mContext;
                } else {
                    listener = (UserActionInterface) fragment;
                }
                listener.onDialogConfirmed(actionType);
            }
        });
        dialogBuilder.setNegativeButton(mContext.getString(R.string.alert_cancel), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        dialogBuilder.show();
    }

    public static void hideKeyboard(final View view) {
        InputMethodManager mgr = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        mgr.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static String getCurrentDate() {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        return format.format(new Date());
    }

    public static boolean validateAadhaar(String num) {
        int[][] d = new int[][]
                {
                        {0, 1, 2, 3, 4, 5, 6, 7, 8, 9},
                        {1, 2, 3, 4, 0, 6, 7, 8, 9, 5},
                        {2, 3, 4, 0, 1, 7, 8, 9, 5, 6},
                        {3, 4, 0, 1, 2, 8, 9, 5, 6, 7},
                        {4, 0, 1, 2, 3, 9, 5, 6, 7, 8},
                        {5, 9, 8, 7, 6, 0, 4, 3, 2, 1},
                        {6, 5, 9, 8, 7, 1, 0, 4, 3, 2},
                        {7, 6, 5, 9, 8, 2, 1, 0, 4, 3},
                        {8, 7, 6, 5, 9, 3, 2, 1, 0, 4},
                        {9, 8, 7, 6, 5, 4, 3, 2, 1, 0}
                };
        int[][] p = new int[][]
                {
                        {0, 1, 2, 3, 4, 5, 6, 7, 8, 9},
                        {1, 5, 7, 6, 2, 8, 3, 0, 9, 4},
                        {5, 8, 0, 3, 7, 9, 6, 1, 4, 2},
                        {8, 9, 1, 6, 0, 4, 3, 5, 2, 7},
                        {9, 4, 5, 3, 1, 2, 6, 8, 7, 0},
                        {4, 2, 8, 6, 5, 7, 3, 9, 0, 1},
                        {2, 7, 9, 3, 8, 0, 6, 4, 1, 5},
                        {7, 0, 4, 6, 9, 1, 3, 2, 5, 8}
                };
        int c = 0;
        int[] myArray = StringToReversedIntArray(num);
        for (int i = 0; i < myArray.length; i++) {
            c = d[c][p[(i % 8)][myArray[i]]];
        }

        return (c == 0);
    }

    private static int[] StringToReversedIntArray(String num) {
        int[] myArray = new int[num.length()];
        for (int i = 0; i < num.length(); i++) {
            myArray[i] = Integer.parseInt(num.substring(i, i + 1));
        }
        myArray = reverse(myArray);
        return myArray;
    }

    private static int[] reverse(int[] myArray) {
        int[] reversed = new int[myArray.length];
        for (int i = 0; i < myArray.length; i++) {
            reversed[i] = myArray[myArray.length - (i + 1)];
        }
        return reversed;
    }

    public static void resetStaticVariables() {
        Constants.cafType = 1;
        Constants.formTime = null;
        Constants.isCAFInEditMode = false;
        Constants.isCAFInEditSILMO = false;
        Constants.isFromCAFResults = false;
        Constants.isFromBasePackage = false;
        Constants.billFrequencyValue = 1;
        Constants.aadhaarData = null;
        Constants.cafNumber = "";
        Constants.customerID = "";
        Constants.pinCode = "";
        Constants.billCycle = "";
        Constants.districtID = "";
        Constants.mandalID = "";
        Constants.villageID = "";
        Constants.oltSerialNumber = "";
        Constants.oltPortNumber = "";
        Constants.Allpackages = "";
        Constants.map = null;
    }
}