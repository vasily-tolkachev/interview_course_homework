package task2.balansed_string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCheckerTest {

    @Test
    void isStringBalancedTest() {
        String rightString1 = "";
        String rightString2 = "(this_{st[]ring}_[is]_balanced)";

        String wrongString1 = "{this_[string}_is_not_]balanced";
        String wrongString2 = "]not_balanced_too";

        assertTrue(StringChecker.isStringBalanced(rightString1));
        assertTrue(StringChecker.isStringBalanced(rightString2));

        assertFalse(StringChecker.isStringBalanced(wrongString1));
        assertFalse(StringChecker.isStringBalanced(wrongString2));
    }
}