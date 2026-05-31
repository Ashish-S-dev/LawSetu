package com.TechCoder.LawSetu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.TechCoder.LawSetu.model.Contact;

import jakarta.mail.internet.MimeMessage;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	private JavaMailSender mailSender;

	@Override
	public void contactUsMail(Contact contactObj) {

		String userEmail = contactObj.getUserEmail();
		String userName = contactObj.getUserName();
		String message = contactObj.getUserMessage();

		String emailMessage = "<!DOCTYPE html>\r\n" + "<html>\r\n" + "<head>\r\n" + "    <meta charset=\"UTF-8\">\r\n"
				+ "    <title>LawSetu - Support Acknowledgement</title>\r\n" + "</head>\r\n" + "\r\n"
				+ "<body style=\"margin:0; padding:0; background-color:#FAFAFA; font-family:Arial, sans-serif;\">\r\n"
				+ "\r\n" + "    <table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" style=\"padding:20px;\">\r\n"
				+ "        <tr>\r\n" + "            <td align=\"center\">\r\n" + "\r\n"
				+ "                <!-- Card -->\r\n"
				+ "                <table width=\"600\" cellpadding=\"0\" cellspacing=\"0\" \r\n"
				+ "                       style=\"background:#ffffff; border-radius:10px; box-shadow:0 4px 10px rgba(0,0,0,.08); padding:30px;\">\r\n"
				+ "\r\n" + "                    <!-- Header -->\r\n" + "                    <tr>\r\n"
				+ "                        <td align=\"center\" style=\"padding-bottom:20px;\">\r\n"
				+ "                            <h2 style=\"margin:0; color:#111111;\">\r\n"
				+ "                                ⚖️ LawSetu\r\n" + "                            </h2>\r\n"
				+ "                            <p style=\"margin:5px 0 0; color:#D4AF37; font-size:14px;\">\r\n"
				+ "                                Trusted Legal Assistance Platform\r\n"
				+ "                            </p>\r\n" + "                        </td>\r\n"
				+ "                    </tr>\r\n" + "\r\n" + "                    <!-- Divider -->\r\n"
				+ "                    <tr>\r\n"
				+ "                        <td style=\"border-top:1px solid #eeeeee; padding-top:20px;\"></td>\r\n"
				+ "                    </tr>\r\n" + "\r\n" + "                    <!-- Body -->\r\n"
				+ "                    <tr>\r\n"
				+ "                        <td style=\"color:#1F2937; font-size:16px; line-height:1.6;\">\r\n" + "\r\n"
				+ "                            <p>Dear <strong>" + userName + "</strong>,</p>\r\n" + "\r\n"
				+ "                            <p>\r\n"
				+ "                                Thank you for reaching out to <strong>LawSetu</strong>. \r\n"
				+ "                                We have successfully received your request and appreciate you bringing this to our attention.\r\n"
				+ "                            </p>\r\n" + "\r\n" + "                            <p>\r\n"
				+ "                                Our team is currently reviewing your query:\r\n"
				+ "                            </p>\r\n" + "\r\n" + "                            <!-- Query Box -->\r\n"
				+ "                            <div style=\"background:#FAFAFA; padding:15px; border-left:4px solid #D4AF37; margin:15px 0; border-radius:5px;\">\r\n"
				+ "                                <em>" + message + "</em>\r\n"
				+ "                            </div>\r\n" + "\r\n" + "                            <p>\r\n"
				+ "                                Please be assured that your request has been accepted and is being processed. \r\n"
				+ "                                We kindly ask you to allow us some time — our team will connect with you shortly \r\n"
				+ "                                and ensure that your concern is addressed effectively.\r\n"
				+ "                            </p>\r\n" + "\r\n" + "                            <p>\r\n"
				+ "                                Your patience and trust in us mean a lot.\r\n"
				+ "                            </p>\r\n" + "\r\n" + "                            <br>\r\n" + "\r\n"
				+ "                            <p style=\"margin-bottom:0;\">\r\n"
				+ "                                Warm regards,<br>\r\n"
				+ "                                <strong>Team LawSetu</strong>\r\n"
				+ "                            </p>\r\n" + "\r\n" + "                        </td>\r\n"
				+ "                    </tr>\r\n" + "\r\n" + "                    <!-- Footer -->\r\n"
				+ "                    <tr>\r\n"
				+ "                        <td style=\"text-align:center; padding-top:25px; font-size:12px; color:#888;\">\r\n"
				+ "                            © 2026 LawSetu. All rights reserved.\r\n"
				+ "                        </td>\r\n" + "                    </tr>\r\n" + "\r\n"
				+ "                </table>\r\n" + "\r\n" + "            </td>\r\n" + "        </tr>\r\n"
				+ "    </table>\r\n" + "\r\n" + "</body>\r\n" + "</html>\r\n" + "";

		MimeMessage mimeMessage = mailSender.createMimeMessage();
		try {
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
			mimeMessageHelper.setTo(userEmail);
			mimeMessageHelper.setSubject("We’ve Received Your Request – LawSetu");
			mimeMessageHelper.setText(emailMessage, true);
			mimeMessageHelper.setFrom("demo.project.asgmail.com");

			mailSender.send(mimeMessage);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void accountCreated(String userEmail) {

		String emailMessage = "<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" \r\n"
				+ "style=\"background:#FAFAFA; padding:40px 0; font-family:Arial,sans-serif;\">\r\n" + "\r\n"
				+ "    <tr>\r\n" + "        <td align=\"center\">\r\n" + "\r\n"
				+ "            <table width=\"650\" cellpadding=\"0\" cellspacing=\"0\"\r\n"
				+ "            style=\"\r\n" + "                background:#ffffff;\r\n"
				+ "                border-radius:18px;\r\n" + "                overflow:hidden;\r\n"
				+ "                box-shadow:0 10px 30px rgba(0,0,0,.08);\r\n" + "            \">\r\n" + "\r\n"
				+ "                <!-- HEADER -->\r\n" + "\r\n" + "                <tr>\r\n"
				+ "                    <td align=\"center\"\r\n" + "                    style=\"\r\n"
				+ "                        background:#111111;\r\n" + "                        padding:35px 20px;\r\n"
				+ "                    \">\r\n" + "\r\n" + "                        <h1 style=\"\r\n"
				+ "                            margin:0;\r\n" + "                            color:#D4AF37;\r\n"
				+ "                            font-size:34px;\r\n"
				+ "                            letter-spacing:1px;\r\n" + "                        \">\r\n"
				+ "                            ⚖️ LawSetu\r\n" + "                        </h1>\r\n" + "\r\n"
				+ "                        <p style=\"\r\n" + "                            color:#ffffff;\r\n"
				+ "                            margin-top:10px;\r\n" + "                            font-size:15px;\r\n"
				+ "                        \">\r\n"
				+ "                            Online Legal Assistance & Lawyer Consultation Platform\r\n"
				+ "                        </p>\r\n" + "\r\n" + "                    </td>\r\n"
				+ "                </tr>\r\n" + "\r\n" + "                <!-- BODY -->\r\n" + "\r\n"
				+ "                <tr>\r\n" + "                    <td style=\"\r\n"
				+ "                        padding:45px 35px;\r\n" + "                        color:#1F2937;\r\n"
				+ "                    \">\r\n" + "\r\n" + "                        <h2 style=\"\r\n"
				+ "                            margin-top:0;\r\n" + "                            color:#111111;\r\n"
				+ "                            font-size:28px;\r\n" + "                        \">\r\n"
				+ "                            Welcome to LawSetu 🎉\r\n" + "                        </h2>\r\n" + "\r\n"
				+ "                        <p style=\"\r\n" + "                            font-size:16px;\r\n"
				+ "                            line-height:1.8;\r\n" + "                        \">\r\n"
				+ "                            Thank you for registering with \r\n"
				+ "                            <b>LawSetu</b>.\r\n"
				+ "                            We sincerely appreciate your trust in our platform.\r\n"
				+ "                        </p>\r\n" + "\r\n" + "                        <p style=\"\r\n"
				+ "                            font-size:16px;\r\n" + "                            line-height:1.8;\r\n"
				+ "                        \">\r\n"
				+ "                            Our mission is to simplify legal assistance by providing a secure, reliable, and user-friendly digital ecosystem connecting clients and advocates.\r\n"
				+ "                        </p>\r\n" + "\r\n" + "                        <!-- HIGHLIGHT BOX -->\r\n"
				+ "\r\n" + "                        <table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\"\r\n"
				+ "                        style=\"\r\n" + "                            background:#FAFAFA;\r\n"
				+ "                            border-left:5px solid #D4AF37;\r\n"
				+ "                            margin:30px 0;\r\n"
				+ "                            border-radius:10px;\r\n" + "                        \">\r\n" + "\r\n"
				+ "                            <tr>\r\n" + "                                <td style=\"\r\n"
				+ "                                    padding:20px;\r\n"
				+ "                                    font-size:15px;\r\n"
				+ "                                    line-height:1.7;\r\n"
				+ "                                    color:#1F2937;\r\n" + "                                \">\r\n"
				+ "\r\n"
				+ "                                    <b>At LawSetu,</b> we are committed to delivering a seamless and trustworthy legal experience for every user.\r\n"
				+ "\r\n" + "                                </td>\r\n" + "                            </tr>\r\n"
				+ "\r\n" + "                        </table>\r\n" + "\r\n" + "                        <p style=\"\r\n"
				+ "                            font-size:16px;\r\n" + "                            line-height:1.8;\r\n"
				+ "                        \">\r\n"
				+ "                            You can now explore advocates, manage legal requests, upload documents securely, and access legal services with ease.\r\n"
				+ "                        </p>\r\n" + "\r\n" + "                        <p style=\"\r\n"
				+ "                            font-size:16px;\r\n" + "                            line-height:1.8;\r\n"
				+ "                            margin-bottom:0;\r\n" + "                        \">\r\n"
				+ "                            Regards,<br>\r\n"
				+ "                            <b>Team LawSetu ⚖️</b>\r\n" + "                        </p>\r\n" + "\r\n"
				+ "                    </td>\r\n" + "                </tr>\r\n" + "\r\n"
				+ "                <!-- FOOTER -->\r\n" + "\r\n" + "                <tr>\r\n"
				+ "                    <td align=\"center\"\r\n" + "                    style=\"\r\n"
				+ "                        background:#111111;\r\n" + "                        padding:18px;\r\n"
				+ "                    \">\r\n" + "\r\n" + "                        <p style=\"\r\n"
				+ "                            color:#ffffff;\r\n" + "                            margin:0;\r\n"
				+ "                            font-size:13px;\r\n" + "                        \">\r\n"
				+ "                            © 2026 LawSetu. All Rights Reserved.\r\n"
				+ "                        </p>\r\n" + "\r\n" + "                    </td>\r\n"
				+ "                </tr>\r\n" + "\r\n" + "            </table>\r\n" + "\r\n" + "        </td>\r\n"
				+ "    </tr>\r\n" + "\r\n" + "</table>";

		MimeMessage mimeMessage = mailSender.createMimeMessage();
		try {
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
			mimeMessageHelper.setTo(userEmail);
			mimeMessageHelper.setSubject("Account Registration Confirmation");
			mimeMessageHelper.setText(emailMessage, true);
			mimeMessageHelper.setFrom("demo.project.asgmail.com");

			mailSender.send(mimeMessage);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void sendOtpEmail(String userEmail, Integer otpValue) {
		String emailMessage = "<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" \r\n"
				+ "style=\"background:#FAFAFA; padding:40px 0; font-family:Arial,sans-serif;\">\r\n" + "\r\n"
				+ "    <tr>\r\n" + "        <td align=\"center\">\r\n" + "\r\n"
				+ "            <table width=\"650\" cellpadding=\"0\" cellspacing=\"0\"\r\n"
				+ "            style=\"\r\n" + "                background:#ffffff;\r\n"
				+ "                border-radius:18px;\r\n" + "                overflow:hidden;\r\n"
				+ "                box-shadow:0 10px 30px rgba(0,0,0,.08);\r\n" + "            \">\r\n" + "\r\n"
				+ "                <!-- HEADER -->\r\n" + "\r\n" + "                <tr>\r\n"
				+ "                    <td align=\"center\"\r\n" + "                    style=\"\r\n"
				+ "                        background:#111111;\r\n" + "                        padding:35px 20px;\r\n"
				+ "                    \">\r\n" + "\r\n" + "                        <h1 style=\"\r\n"
				+ "                            margin:0;\r\n" + "                            color:#D4AF37;\r\n"
				+ "                            font-size:34px;\r\n"
				+ "                            letter-spacing:1px;\r\n" + "                        \">\r\n"
				+ "                            ⚖️ LawSetu\r\n" + "                        </h1>\r\n" + "\r\n"
				+ "                        <p style=\"\r\n" + "                            color:#ffffff;\r\n"
				+ "                            margin-top:10px;\r\n" + "                            font-size:15px;\r\n"
				+ "                        \">\r\n" + "                            Secure OTP Verification\r\n"
				+ "                        </p>\r\n" + "\r\n" + "                    </td>\r\n"
				+ "                </tr>\r\n" + "\r\n" + "                <!-- BODY -->\r\n" + "\r\n"
				+ "                <tr>\r\n" + "                    <td style=\"\r\n"
				+ "                        padding:45px 35px;\r\n" + "                        color:#1F2937;\r\n"
				+ "                    \">\r\n" + "\r\n" + "                        <h2 style=\"\r\n"
				+ "                            margin-top:0;\r\n" + "                            color:#111111;\r\n"
				+ "                            font-size:28px;\r\n" + "                        \">\r\n"
				+ "                            Email Verification 🔐\r\n" + "                        </h2>\r\n" + "\r\n"
				+ "                        <p style=\"\r\n" + "                            font-size:16px;\r\n"
				+ "                            line-height:1.8;\r\n" + "                        \">\r\n"
				+ "                            Thank you for choosing \r\n"
				+ "                            <b>LawSetu</b>.\r\n"
				+ "                            To continue securely, please verify your email address using the OTP below.\r\n"
				+ "                        </p>\r\n" + "\r\n" + "                        <!-- OTP BOX -->\r\n" + "\r\n"
				+ "                        <table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\"\r\n"
				+ "                        style=\"\r\n" + "                            margin:35px 0;\r\n"
				+ "                        \">\r\n" + "\r\n" + "                            <tr>\r\n"
				+ "                                <td align=\"center\">\r\n" + "\r\n"
				+ "                                    <div style=\"\r\n"
				+ "                                        display:inline-block;\r\n"
				+ "                                        background:#FAFAFA;\r\n"
				+ "                                        border:2px dashed #D4AF37;\r\n"
				+ "                                        padding:22px 40px;\r\n"
				+ "                                        border-radius:14px;\r\n"
				+ "                                        font-size:38px;\r\n"
				+ "                                        font-weight:bold;\r\n"
				+ "                                        letter-spacing:10px;\r\n"
				+ "                                        color:#111111;\r\n"
				+ "                                    \">\r\n" + "\r\n" + "                                        "
				+ otpValue + "\r\n" + "\r\n" + "                                    </div>\r\n" + "\r\n"
				+ "                                </td>\r\n" + "                            </tr>\r\n" + "\r\n"
				+ "                        </table>\r\n" + "\r\n" + "                        <p style=\"\r\n"
				+ "                            font-size:15px;\r\n" + "                            line-height:1.8;\r\n"
				+ "                        \">\r\n" + "                            This OTP is valid for the next \r\n"
				+ "                            <b>10 minutes</b>.\r\n"
				+ "                            Please do not share this code with anyone for security reasons.\r\n"
				+ "                        </p>\r\n" + "\r\n" + "                        <!-- SECURITY BOX -->\r\n"
				+ "\r\n" + "                        <table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\"\r\n"
				+ "                        style=\"\r\n" + "                            background:#FAFAFA;\r\n"
				+ "                            border-left:5px solid #D4AF37;\r\n"
				+ "                            margin:30px 0;\r\n"
				+ "                            border-radius:10px;\r\n" + "                        \">\r\n" + "\r\n"
				+ "                            <tr>\r\n" + "                                <td style=\"\r\n"
				+ "                                    padding:20px;\r\n"
				+ "                                    font-size:15px;\r\n"
				+ "                                    line-height:1.7;\r\n"
				+ "                                    color:#1F2937;\r\n" + "                                \">\r\n"
				+ "\r\n" + "                                    <b>Security Notice:</b> \r\n"
				+ "                                    LawSetu will never ask for your OTP through calls, messages, or emails.\r\n"
				+ "\r\n" + "                                </td>\r\n" + "                            </tr>\r\n"
				+ "\r\n" + "                        </table>\r\n" + "\r\n" + "                        <p style=\"\r\n"
				+ "                            font-size:16px;\r\n" + "                            line-height:1.8;\r\n"
				+ "                            margin-bottom:0;\r\n" + "                        \">\r\n"
				+ "                            Regards,<br>\r\n"
				+ "                            <b>Team LawSetu ⚖️</b>\r\n" + "                        </p>\r\n" + "\r\n"
				+ "                    </td>\r\n" + "                </tr>\r\n" + "\r\n"
				+ "                <!-- FOOTER -->\r\n" + "\r\n" + "                <tr>\r\n"
				+ "                    <td align=\"center\"\r\n" + "                    style=\"\r\n"
				+ "                        background:#111111;\r\n" + "                        padding:18px;\r\n"
				+ "                    \">\r\n" + "\r\n" + "                        <p style=\"\r\n"
				+ "                            color:#ffffff;\r\n" + "                            margin:0;\r\n"
				+ "                            font-size:13px;\r\n" + "                        \">\r\n"
				+ "                            © 2026 LawSetu. All Rights Reserved.\r\n"
				+ "                        </p>\r\n" + "\r\n" + "                    </td>\r\n"
				+ "                </tr>\r\n" + "\r\n" + "            </table>\r\n" + "\r\n" + "        </td>\r\n"
				+ "    </tr>\r\n" + "\r\n" + "</table>";

		MimeMessage mimeMessage = mailSender.createMimeMessage();
		try {
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
			mimeMessageHelper.setTo(userEmail);
			mimeMessageHelper.setSubject("Lawsetu - Your OTP for Verification");
			mimeMessageHelper.setText(emailMessage, true);
			mimeMessageHelper.setFrom("demo.project.asgmail.com");

			mailSender.send(mimeMessage);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void accountActivated(String userEmail) {

		String emailMessage = "<tr> <td align=\"center\"> <table width=\"650\" cellpadding=\"0\" cellspacing=\"0\" "
				+ "style=\" background:#ffffff; border-radius:18px; overflow:hidden; box-shadow:0 10px 30px "
				+ "rgba(0,0,0,.08); \"> <!-- HEADER --> <tr> <td align=\"center\" style=\" background:#111111; "
				+ "padding:35px 20px; \"> <h1 style=\" margin:0; color:#D4AF37; font-size:34px; letter-spacing:1px; \"> "
				+ "⚖️ LawSetu </h1> <p style=\" color:#ffffff; margin-top:10px; font-size:15px; \"> Account Activation "
				+ "Successful </p> </td> </tr> <!-- BODY --> <tr> <td style=\" padding:45px 35px; color:#1F2937; \"> "
				+ "<h2 style=\" margin-top:0; color:#111111; font-size:28px; \"> Welcome to LawSetu 🎉 </h2> <p style=\" "
				+ "font-size:16px; line-height:1.8; \"> Congratulations! Your <b>LawSetu account</b> has been successfully"
				+ " activated. </p> <p style=\" font-size:16px; line-height:1.8; \"> You can now access and use all "
				+ "available services on the platform, including advocate discovery, legal request management, secure"
				+ " document handling, appointments, and more. </p> <!-- SUCCESS BOX --> <table width=\"100%\" "
				+ "cellpadding=\"0\" cellspacing=\"0\" style=\" background:#FAFAFA; border-left:5px solid #D4AF37;"
				+ " margin:30px 0; border-radius:10px; \"> <tr> <td style=\" padding:20px; font-size:15px; "
				+ "line-height:1.7; color:#1F2937; \"> <b>Your account is now fully verified and active.</b> Thank you "
				+ "for trusting LawSetu as your digital legal assistance platform. </td> </tr> </table> <p style=\""
				+ " font-size:16px; line-height:1.8; \"> We are committed to providing a secure, seamless, and modern "
				+ "legal experience for all users. </p> <p style=\" font-size:16px; line-height:1.8; margin-bottom:0; \"> "
				+ "Regards,<br> <b>Team LawSetu ⚖️</b> </p> </td> </tr> <!-- FOOTER --> <tr> <td align=\"center\" style=\""
				+ " background:#111111; padding:18px; \"> <p style=\" color:#ffffff; margin:0; font-size:13px; \"> "
				+ "© 2026 LawSetu. All Rights Reserved. </p> </td> </tr> </table> </td> </tr>";
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		try {
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
			mimeMessageHelper.setTo(userEmail);
			mimeMessageHelper.setSubject("Your LawSetu Account Has Been Successfully Activated");
			mimeMessageHelper.setText(emailMessage, true);
			mimeMessageHelper.setFrom("demo.ashish.asgmail.com");
			mailSender.send(mimeMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
