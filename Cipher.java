public class Cipher   
{
    public static final String ORIGINAL_ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    public static final String CIPHER_ALPHABET = "dfxyhrklvwuasgimnojpqetbcz";

    // Encrypt the input string
    public String encrypt(String inputString) {
        StringBuilder outputString = new StringBuilder();

        for (int i = 0; i < inputString.length(); i++) {
            char currentChar = inputString.charAt(i);
            outputString.append(replaceChar(currentChar, true));
        }

        return outputString.toString();
    }

    // Decrypt the input string
    public String decrypt(String inputString) {
        StringBuilder outputString = new StringBuilder();

        for (int i = 0; i < inputString.length(); i++) {
            char currentChar = inputString.charAt(i);
            outputString.append(replaceChar(currentChar, false));
        }

        return outputString.toString();
    }

    // Replaces the given input char based on the isEncrypt flag
    private char replaceChar(char inputChar, boolean isEncrypt) {
        if (Character.isLetter(inputChar)) {
            inputChar = Character.toLowerCase(inputChar);  // Handle lowercase only

            // Map from original to cipher or vice versa
            String fromAlphabet = isEncrypt ? ORIGINAL_ALPHABET : CIPHER_ALPHABET;
            String toAlphabet = isEncrypt ? CIPHER_ALPHABET : ORIGINAL_ALPHABET;

            int index = fromAlphabet.indexOf(inputChar);
            if (index != -1) {
                return toAlphabet.charAt(index);
            }
        }
        
        // Return original character if not found in alphabet (e.g., symbols or upper case letters)
        return inputChar;
    }
}