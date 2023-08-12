import javax.management.AttributeChangeNotification;
import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;

public class LogControl extends NotificationBroadcasterSupport implements LogControlMBean {

    private boolean loggingEnabled = true;

    @Override
    public boolean isLoggingEnabled() {
        return loggingEnabled;
    }

    @Override
    public void setLoggingEnabled(boolean enabled) {
        loggingEnabled = enabled;
        String message = enabled ? "Logging enabled" : "Logging disabled";
        Notification notification = new AttributeChangeNotification(
                this,
                0,
                System.currentTimeMillis(),
                message,
                "LoggingEnabled",
                "boolean",
                !enabled,
                enabled
        );
        sendNotification(notification);
        LoggingAspect.setLoggingEnabled(enabled);
    }
}

