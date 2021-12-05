/**
 * @author Shiv Gaurang Desai
 */
package com.playup.dao.payment;

import com.playup.constants.QueryConstants;
import com.playup.database.PlayupDBConnection;
import com.playup.model.payment.PaymentModel;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PaymentDao implements IPaymentDao{
    private static PaymentDao paymentDaoInstance;

    private PaymentDao(){}

    public static PaymentDao getInstance () {
        if(paymentDaoInstance==null) {
            paymentDaoInstance = new PaymentDao();
            return paymentDaoInstance;
        }
        return paymentDaoInstance;
    }

    @Override
    public boolean checkWhetherTransactionExist(int ticketNumber) throws SQLException {
        String sqlQuery = String.format(QueryConstants.CHECK_TRANSACTION_ID_NUMBER_QUERY,ticketNumber);
        ResultSet resultSet = PlayupDBConnection.getInstance().readData(sqlQuery);
        if (resultSet.next()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean completePayment(PaymentModel paymentModel) throws SQLException {
        String sqlQuery = String.format(QueryConstants.INSERT_TRANSACTION_QUERY,paymentModel.getTransactionId(),paymentModel.getName(),paymentModel.getAmount(),paymentModel.getTimeStamp(),paymentModel.getCardNumber());
        return  PlayupDBConnection.getInstance().updateData(sqlQuery);
    }
}
