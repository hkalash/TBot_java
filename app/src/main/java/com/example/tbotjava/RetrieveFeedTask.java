package com.example.tbotjava;

import android.os.AsyncTask;

import io.gate.gateapi.ApiClient;
import io.gate.gateapi.ApiException;
import io.gate.gateapi.Configuration;
import io.gate.gateapi.GateApiException;
import io.gate.gateapi.api.AccountApi;
import io.gate.gateapi.models.AccountDetail;

public class RetrieveFeedTask extends AsyncTask<String, Void, String> {

    @Override
    protected String doInBackground(String... strings) {

        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.gateio.ws/api/v4");

        // Configure APIv4 authorization: apiv4
        // secret key :b8f789544b50f2edc3c05b7cb8293c7072f83ecfc33c270fa2377371696577eb
       // test keys :
        // defaultClient.setApiKeySecret("40ddff2753ca923d147d009e920641f8", "b8f789544b50f2edc3c05b7cb8293c7072f83ecfc33c270fa2377371696577eb");
        defaultClient.setApiKeySecret("c4cd22b998cd5860654a406afa0384f2",
                "b8f789544b50f2edc3c05b7cb8293c7072f83ecfc33c270fa2377371696577eb");

        AccountApi apiInstance = new AccountApi(defaultClient);
        try {
            AccountDetail result = apiInstance.getAccountDetail();
            System.out.println(result);
        } catch (GateApiException e) {
            System.err.println(String.format("Gate api exception, label: %s, message: %s", e.getErrorLabel(), e.getMessage()));
            e.printStackTrace();
        } catch (ApiException e) {
            System.err.println("Exception when calling AccountApi#getAccountDetail");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
        return null;
    }
}
