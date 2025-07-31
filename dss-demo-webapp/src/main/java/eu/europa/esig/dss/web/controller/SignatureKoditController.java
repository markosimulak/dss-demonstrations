package eu.europa.esig.dss.web.controller;

import eu.europa.esig.dss.web.model.SignDocumentResponse;
import eu.europa.esig.dss.web.model.SignRequest;
import eu.europa.esig.dss.web.model.SignResponse;
import eu.europa.esig.dss.web.model.SignatureDocumentForm;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes(value = { "signatureDocumentForm", "signedDocument" })
@RequestMapping(value = "/sign-a-document-kodit")
public class SignatureKoditController {

    private static final Logger LOG = LoggerFactory.getLogger(SignatureKoditController.class);

    private static final String SIGNATURE_PARAMETERS = "signature";
    private static final String SIGNATURE_PROCESS = "nexu-signature-process";

    private static final String[] ALLOWED_FIELDS = { "documentToSign", "containerType", "signatureForm", "signaturePackaging",
            "signatureLevel", "digestAlgorithm", "signWithExpiredCertificate", "addContentTimestamp" };

    @InitBinder
    public void setAllowedFields(WebDataBinder webDataBinder) {
        webDataBinder.setAllowedFields(ALLOWED_FIELDS);
    }

    @RequestMapping(value = "/sign-document", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public SignDocumentResponse signDocument(@RequestBody SignRequest request) {
        LOG.info("Sign document with Kodit");
        LOG.info(request.toString());

        SignDocumentResponse signedDocumentResponse = new SignDocumentResponse();
        signedDocumentResponse.setUrlToDownload("download");
        return signedDocumentResponse;
    }
}

