package cn.sudiyi.platform.internal;

import cn.sudiyi.platform.common.auth.CredentialsProvider;
import cn.sudiyi.platform.common.comm.ServiceClient;
import cn.sudiyi.platform.common.http.HttpResponse;
import cn.sudiyi.platform.common.http.TextPost;
import cn.sudiyi.platform.common.json.JSONConverter;
import cn.sudiyi.platform.common.parser.ResponseParseException;
import cn.sudiyi.platform.common.parser.ResponseParser;
import cn.sudiyi.platform.common.utils.CodingUtils;
import cn.sudiyi.platform.model.request.CodeEndRequest;

/**
 * Created by pktczwd on 2016/11/15.
 */
public class PlatformCodeOperation extends PlatformOperation {

    public PlatformCodeOperation(ServiceClient client, CredentialsProvider credsProvider) {
        super(client, credsProvider);
    }

    public void codeEnd(CodeEndRequest request) {

        CodingUtils.assertParameterNotNull(request, "codeEndRequest");
        CodingUtils.assertParameterNotNull(request.getReservationId(), "codeEndRequest.reservationId");
        CodingUtils.assertParameterNotNull(request.getOpenCode(), "codeEndRequest.openCode");

        String url = new StringBuilder(getEndpoint().toString()).append("/v3/code/end").toString();
        TextPost post = new TextPost(url);
        post.setBody(JSONConverter.toJson(request));

        doOperation(post, new ResponseParser<Void>() {

            @Override
            public Void parse(HttpResponse response) throws ResponseParseException {
                return null;
            }
        });
    }
}
