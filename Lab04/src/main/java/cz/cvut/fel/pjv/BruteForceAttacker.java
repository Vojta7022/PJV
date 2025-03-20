package cz.cvut.fel.pjv;

public class BruteForceAttacker extends Thief {
    @Override
    public void breakPassword(int sizeOfPassword) {
        char[] attempt = new char[sizeOfPassword];
        tryAllCombinations(attempt, 0);
    }

    private void tryAllCombinations(char[] attempt, int position) {
        if (position == attempt.length) {
            if (tryOpen(attempt)) {
                return;
            }
        } else {
            for (char c : getCharacters()) {
                attempt[position] = c;
                tryAllCombinations(attempt, position + 1);
                if (isOpened()) {
                    return;
                }
            }
        }
    }
}