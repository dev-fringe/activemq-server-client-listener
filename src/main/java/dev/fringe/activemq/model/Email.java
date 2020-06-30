package dev.fringe.activemq.model;

import java.util.Arrays;

import lombok.Data;

@Data
public class Email {

    private String toRecipient;
    private String[] ccRecipients;
    private String[] bccRecipients;
    private String subject;
    private String emailBody;
    
    public String toString() {
        final StringBuilder sb = new StringBuilder("Email{");
        sb.append("toRecipient='").append(toRecipient).append('\'');
        sb.append(", ccRecipients=").append(Arrays.toString(ccRecipients));
        sb.append(", bccRecipients=").append(Arrays.toString(bccRecipients));
        sb.append(", subject='").append(subject).append('\'');
        sb.append(", emailBody='").append(emailBody).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
