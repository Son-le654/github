package com.fpt.confluence.plans.approval.rest;

import com.mysql.jdbc.Driver;
import com.atlassian.mail.Email;
import com.atlassian.mail.MailException;
import com.fpt.confluence.plans.approval.models.SimpleRestResponse;
import com.fpt.confluence.plans.approval.models.Content;
import com.fpt.confluence.plans.approval.rest.ContentDAO;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.PathParam;
import java.util.*;
import java.sql.*;

@Path("/plans")
@Produces({MediaType.APPLICATION_JSON})
public class PlanApproveResources {


    @GET
    @Path("/{contentId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getContentById(@PathParam("contentId") long contentId) {
        // Gọi phương thức getContentById từ lớp ContentDAO
        ContentDAO contentDAO = new ContentDAO();
        Content content = contentDAO.getContentById(contentId);
        
        if (content != null) {
            return Response.status(Response.Status.OK).entity("OK").build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    @Path("/approve")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response approve() {
        SimpleRestResponse response = new SimpleRestResponse();
        response.setMessage("Hello world this is approved");
        return Response.ok(response).build();
    }

    @POST
    @Path("/reject")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response reject() {
        SimpleRestResponse response = new SimpleRestResponse();
        response.setMessage("Hello world this is rejected");
        return Response.ok(response).build();
    }
}
