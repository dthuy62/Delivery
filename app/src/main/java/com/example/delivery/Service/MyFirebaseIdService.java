package com.example.delivery.Service;


import androidx.annotation.NonNull;

import com.example.delivery.Common.Common;
import com.example.delivery.Model.Tokens;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;


public class MyFirebaseIdService extends FirebaseInstanceIdService {
    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        sendTokenToServer(refreshedToken);
    }

    private void sendTokenToServer(String refreshedToken) {
        if(Common.currentShipper != null)
        {
            FirebaseDatabase db = FirebaseDatabase.getInstance();
            DatabaseReference token = db.getReference("Tokens");
            Tokens data = new Tokens(refreshedToken, true);
            token.child(Common.currentShipper.getPhone()).setValue(data);
        }
    }
}
