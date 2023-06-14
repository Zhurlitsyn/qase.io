//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package tests.base;

import lombok.extern.log4j.Log4j2;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

@Log4j2
public class Retry implements IRetryAnalyzer {
    private int attempt = 1;
    private static final int MAX_RETRY = 2;

    public Retry() {
    }

    public boolean retry(ITestResult iTestResult) {
        if (!iTestResult.isSuccess()) {
            if (this.attempt < MAX_RETRY) {
                ++this.attempt;
                iTestResult.setStatus(2);
                log.warn("Test {} failed once again.", iTestResult.getName());
                log.info("Attempt# " + this.attempt);
                return true;
            }

            iTestResult.setStatus(2);
        } else {
            iTestResult.setStatus(1);
        }

        return false;
    }
}
