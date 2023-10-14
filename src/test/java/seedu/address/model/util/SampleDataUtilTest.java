package seedu.address.model.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.model.util.SampleDataUtil.getSamplePersons;
import static seedu.address.model.util.SampleDataUtil.getSessionSet;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

import seedu.address.model.person.Person;
import seedu.address.model.session.Session;


public class SampleDataUtilTest {

    @Test
    public void getSessionSet_withValidSessionNumbers_returnsExpectedSessions() {
        String[] validSessionNumbers = { "1", "2", "3" };
        Set<Session> result = getSessionSet(validSessionNumbers);
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

    @Test
    public void codeCov_coverPersonArrayTests_withSamplePersons() {
        Person[] samplePersons = getSamplePersons();
        Person alex = samplePersons[0];

        // Create an expected list of session numbers as strings
        List<String> expectedSessionNumbers = Arrays.asList("0");
        // Get the actual list of session numbers
        List<String> actualSessionNumbers = alex.getSessionNumberArray();

        assertEquals(expectedSessionNumbers, actualSessionNumbers);
    }

}
