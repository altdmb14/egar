package ru.clientsoap.client;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import ru.clientsoap.wsdl.GetTimeRequest;
import ru.clientsoap.wsdl.GetTimeResponse;

public class SoapClient extends WebServiceGatewaySupport {

    public GetTimeResponse getDateTimeRemote(int numb) {
        GetTimeRequest request = new GetTimeRequest();
        request.setTime(numb);

        GetTimeResponse response = (GetTimeResponse) getWebServiceTemplate()
                .marshalSendAndReceive(request);

        return response;
    }
}