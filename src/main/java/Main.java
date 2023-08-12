import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);


        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        ObjectName name = new ObjectName("com.example:type=LogControl");
        LogControl mbean = new LogControl();
        mbs.registerMBean(mbean, name);

        StringConverter converter = new StringConverter();

        System.out.println("Enter a string:");
        String input = scanner.nextLine();
        String converted = converter.convertString(input);
        System.out.println("Converted string: " + converted);

        System.out.println("Do you want to enable/disable logging? (yes/no)");
        String response = scanner.nextLine();
        if ("yes".equalsIgnoreCase(response)) {
            System.out.println("Enter 'true' to enable logging or 'false' to disable logging:");
            boolean loggingEnabled = Boolean.parseBoolean(scanner.nextLine());
            mbean.setLoggingEnabled(loggingEnabled);
        }

        scanner.close();
    }
}
