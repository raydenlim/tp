package seedu.address.model.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import seedu.address.model.session.Session;


public class SampleDataUtilTest {

    @Test
    public void getSessionSet_withValidSessionNumbers_returnsExpectedSessions() {
        String[] validSessionNumbers = { "1", "2", "3" };
        Set<Session> result = SampleDataUtil.getSessionSet(validSessionNumbers);
        Set<Session> expectedSet = new HashSet<>(Arrays.asList(new Session("1"), new Session("2"), new Session("3")));

        Set<String> resultSessionNumbers = new HashSet<>();
        Set<String> expectedSessionNumbers = new HashSet<>();

        for (Session session : result) {
            resultSessionNumbers.add(session.getSessionNumber());
        }
        for (Session session : expectedSet) {
            expectedSessionNumbers.add(session.getSessionNumber());
        }

        assertEquals(resultSessionNumbers, expectedSessionNumbers);
    }
}
