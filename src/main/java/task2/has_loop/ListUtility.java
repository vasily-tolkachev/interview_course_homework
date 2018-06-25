package task2.has_loop;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ListUtility {

    public boolean hasLoop(Node node) {
        if (node == null || node.next == null || node.next.next == null) return false;
        Node oneStepRunner = node;
        Node twoStepRunner = node;
        while (twoStepRunner != null && twoStepRunner.next != null) {
            oneStepRunner = oneStepRunner.next;
            twoStepRunner = twoStepRunner.next.next;
            if (oneStepRunner == twoStepRunner) {
                return true;
            }
        }
        return false;
    }
}
