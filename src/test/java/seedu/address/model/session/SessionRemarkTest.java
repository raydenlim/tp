package seedu.address.model.session;

import org.junit.jupiter.api.Test;

public class SessionRemarkTest {

    @Test
    public void isValidSessionRemark_validSessionRemark_returnTrue() {
        // Valid session remarks
        assertIsValidSessionRemark("This is a valid remark");
        assertIsValidSessionRemark("123456");
        assertIsValidSessionRemark("Alphanumeric_123");
    }

    @Test
    public void isValidSessionRemark_invalidSessionRemark_returnFalse() {
        // Invalid session remarks
        assertIsInvalidSessionRemark(""); // Empty string
        assertIsInvalidSessionRemark("   "); // Blank string
        assertIsInvalidSessionRemark("!@#$"); // Special characters
    }

    private void assertIsValidSessionRemark(String sessionRemark) {
        assert SessionRemark.isValidSessionRemark(sessionRemark);
    }

    private void assertIsInvalidSessionRemark(String sessionRemark) {
        assert !SessionRemark.isValidSessionRemark(sessionRemark);
    }
}
