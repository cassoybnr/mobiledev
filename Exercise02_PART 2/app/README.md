# Exercise 02 - Campus Password

## How the Password Validation Works (Java String Methods Used)

1. **`getText().toString()`** — Converts the EditText input object into a plain String
2. **`.trim()`** — Removes any accidental leading/trailing spaces the user typed
3. **`.length()`** — Checks that the Student ID has at least 2 characters
4. **`.substring(studentId.length() - 2)`** — Extracts the last 2 digits from the ID
5. **String concatenation (`+`)** — Joins the wall color and last 2 digits to build the expected password
6. **`.equalsIgnoreCase()`** — Compares the user's input to the expected password, ignoring uppercase/lowercase

## Example
- Lab wall color: `blue`
- Student ID entered: `12345`
- Last 2 digits: `45`
- Expected password: `blue45`