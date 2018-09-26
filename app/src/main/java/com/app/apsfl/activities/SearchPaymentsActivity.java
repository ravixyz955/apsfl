package com.app.apsfl.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.app.apsfl.R;
import com.app.apsfl.adapters.PaymentsAdapter;
import com.app.apsfl.httpClient.RequestHandler;
import com.app.apsfl.interfaces.ResponseHandler;
import com.app.apsfl.models.PaymentModel;
import com.app.apsfl.utils.Constants;
import com.app.apsfl.utils.FormValidations;
import com.app.apsfl.utils.RecyclerViewClickListener;
import com.app.apsfl.utils.Utils;

import java.util.ArrayList;

public class SearchPaymentsActivity extends AppCompatActivity
        implements View.OnClickListener, ResponseHandler {

    private Toolbar mToolbar;
    private RecyclerView paymentRecyclerView;
    private PaymentsAdapter paymentAdapter;
    private ArrayList<PaymentModel> paymentList;
    private EditText paymentsMobileEditText;
    private Button searchPaymentButton;
    private RequestHandler requestHandler;
    private TextView noPaymentsMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_payments);
        initViews();
        setupToolBar();
        registerListeners();
        setupRecyclerView();
    }

    private void initViews() {
        requestHandler = new RequestHandler();
        mToolbar = (Toolbar) findViewById(R.id.toolBar);
        paymentRecyclerView = (RecyclerView) findViewById(R.id.paymentRecyclerView);
        noPaymentsMessage = (TextView) findViewById(R.id.noPaymentsMessage);
        paymentList = new ArrayList<>();
        paymentAdapter = new PaymentsAdapter(this, paymentList);
        paymentsMobileEditText = (EditText) findViewById(R.id.paymentsMobileEditText);
        searchPaymentButton = (Button) findViewById(R.id.searchPaymentButton);
        paymentsMobileEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    Utils.hideKeyboard(v);
                    searchPaymentButton.performClick();
                    return true;
                }
                return false;
            }
        });
    }

    private void setupToolBar() {
        setSupportActionBar(mToolbar);
        ActionBar mActionBar = getSupportActionBar();
        if (mActionBar != null) {
            mActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void registerListeners() {
        searchPaymentButton.setOnClickListener(this);
    }

    private void setupRecyclerView() {
        paymentRecyclerView.setLayoutManager(
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        paymentRecyclerView.setAdapter(paymentAdapter);
        paymentRecyclerView.addOnItemTouchListener(new RecyclerViewClickListener(this,
                new RecyclerViewClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Log.d("Payment Position", "\t" + position);
                        Intent intent = new Intent(SearchPaymentsActivity.this, MakePaymentActivity.class);
                        intent.putExtra("paymentModel", paymentList.get(position));
                        startActivity(intent);
                    }
                }
        ));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                super.onBackPressed();
                return true;
        }
        return false;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.searchPaymentButton:
                Utils.hideKeyboard(v);
                if (FormValidations.isFormEditTextValid(paymentsMobileEditText, FormValidations.FORM_FIELDS.MOBILE)) {
                    Utils.showProgress(this, getString(R.string.getting_payment_list));
                    requestHandler.getMonthlyPayments(this,
                            paymentsMobileEditText.getText().toString(),
                            Constants.GET_MONTHLY_PAYMENTS);
                }
                break;
        }
    }

    @Override
    public void responseHandler(Object response, int requestType) {
        switch (requestType) {
            case Constants.GET_MONTHLY_PAYMENTS:
                Utils.cancelProgress();
                if (response != null) {
                    paymentList.clear();
                    //noinspection unchecked
                    paymentList.addAll((ArrayList<PaymentModel>) response);
                    if (paymentList.size() > 0) {
                        paymentRecyclerView.setVisibility(View.VISIBLE);
                        noPaymentsMessage.setVisibility(View.GONE);
                    } else {
                        paymentRecyclerView.setVisibility(View.GONE);
                        noPaymentsMessage.setVisibility(View.VISIBLE);
                    }
                    paymentAdapter.notifyDataSetChanged();
                }
                break;
        }
    }
}