package com.fpt.confluence.plans.approval.mails;

import com.atlassian.confluence.mail.ConfluenceMailServerManager;
import com.atlassian.confluence.mail.template.ConfluenceMailQueueItem;
import com.atlassian.mail.Email;
import com.atlassian.mail.MailException;
import com.atlassian.mail.queue.MailQueueItem;
import com.atlassian.mail.server.SMTPMailServer;
import com.atlassian.sal.api.component.ComponentLocator;

import static com.atlassian.confluence.mail.template.ConfluenceMailQueueItem.MIME_TYPE_HTML;

public class MailService {
    private final SMTPMailServer mailServer;

    public MailService() {
        ConfluenceMailServerManager confluenceMailServerManager = ComponentLocator
                .getComponent(ConfluenceMailServerManager.class);
        this.mailServer = confluenceMailServerManager.getDefaultSMTPMailServer();
    }

    /**
     * Send directly by mail server
     *
     * @param email
     * @throws MailException
     */
    public void sendEmail(Email email) throws MailException {
        this.mailServer.send(email);
    }

    /**
     * Send by Confluence Mail Queue
     *
     * @param to
     * @param subject
     * @param body
     * @throws MailException
     */
    public void sendMail(
            String to,
            String subject,
            String body
    ) throws MailException {
        MailQueueItem mailQueueItem = new ConfluenceMailQueueItem(to, subject, body, MIME_TYPE_HTML);
        mailQueueItem.send();
    }
}
