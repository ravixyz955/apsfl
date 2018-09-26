package com.app.apsfl.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.apsfl.R;
import com.app.apsfl.models.PaymentModel;

import java.util.ArrayList;

public class PaymentsAdapter
        extends RecyclerView.Adapter<PaymentsAdapter.TransactionViewHolder> {

    private Context mContext;
    private ArrayList<PaymentModel> paymentList;

    public PaymentsAdapter(Context mContext, ArrayList<PaymentModel> transactionList) {
        this.mContext = mContext;
        this.paymentList = transactionList;
    }

    @Override
    public TransactionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View rowView = inflater.inflate(R.layout.row_payment_list, parent, false);
        return new TransactionViewHolder(rowView);
    }

    @Override
    public void onBindViewHolder(TransactionViewHolder holder, int position) {
        PaymentModel model = paymentList.get(position);
        holder.paymentCustomerName.setText(model.getPaymentCustomerName());
        holder.paymentAadhaarNumber.setText(model.getPaymentAadhaarNumber());
       // holder.paymentCAFNumber.setText(model.getPaymentCAFNumber());
        holder.paymentCustomerID.setText(model.getPaymentCustomerID());
        holder.paymentTotalCharge.setText(model.getPaymentTotalCharges());
    }

    @Override
    public int getItemCount() {
        return paymentList.size();
    }

    class TransactionViewHolder extends RecyclerView.ViewHolder {

        private TextView paymentCustomerName, paymentAadhaarNumber,
                 paymentCustomerID, paymentTotalCharge;//paymentCAFNumber,

        TransactionViewHolder(View itemView) {
            super(itemView);
            paymentCustomerName = (TextView) itemView.findViewById(R.id.paymentCustomerName);
            paymentAadhaarNumber = (TextView) itemView.findViewById(R.id.paymentAadhaarNumber);
           // paymentCAFNumber = (TextView) itemView.findViewById(R.id.paymentCAFNumber);
            paymentCustomerID = (TextView) itemView.findViewById(R.id.paymentCustomerID);
            paymentTotalCharge = (TextView) itemView.findViewById(R.id.paymentTotalCharge);
        }
    }
}