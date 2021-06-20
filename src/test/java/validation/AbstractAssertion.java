package validation;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import Base.BasePage;
import stepDefinition.AbstractTest;

public class AbstractAssertion<T extends BasePage>extends AbstractTest {
    protected static final Log logger = LogFactory.getLog(AbstractAssertion.class);

    protected T basePage;

    public T endAssertion() {
        return basePage;
    }

    public void setPage(T funtionalLibrary) {
        this.basePage = funtionalLibrary;
    }
}
