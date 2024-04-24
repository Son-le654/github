package com.fpt.confluence.plans.approval.rest;

import com.atlassian.mail.Email;
import com.atlassian.mail.MailException;
import com.fpt.confluence.plans.approval.mails.MailService;
import com.fpt.confluence.plans.approval.models.SimpleRestResponse;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/mail-sender")
@Produces({MediaType.APPLICATION_JSON})
public class MailSenderResource {
    private final MailService mailService;

    public MailSenderResource() {
        this.mailService = new MailService();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response sendMessage() {
        SimpleRestResponse response = new SimpleRestResponse();

        Email email = new Email(
                "whoever@atlassian.com",
                "A test email",
                "The body of the message"
        );

        try {

//            this.mailService.sendMail(
//                    "whoever@atlassian.com",
//                    "A test email",
//                    "The body of the message"
//            );
            this.mailService.sendEmail(email);
            response.setMessage("Succeed to send mail");
            return Response.ok(response).build();
        } catch (MailException e) {
            response.setMessage("Failed to send mail");
            return Response.ok(response).build();
        }
    }
}
