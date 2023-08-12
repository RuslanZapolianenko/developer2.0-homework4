import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LoggingAspect {

    private static boolean loggingEnabled = true;

    public static void setLoggingEnabled(boolean enabled) {
        loggingEnabled = enabled;
    }

    @AfterReturning(pointcut = "execution(* convertString(..))", returning = "result")
    public void logConversion(String result) {
        if (loggingEnabled) {
            System.out.println("Original String: " + StringConverter.getInputString());
            System.out.println("Converted String: " + result);
        }
    }
}
