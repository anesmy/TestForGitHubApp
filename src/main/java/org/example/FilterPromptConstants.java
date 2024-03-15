package ltd.clearsolutions.codereviewaiassistant.utils.constants;

public class FilterPromptConstants {

    public static final String NO_BUGS_DETECTED = "NO BUGS";

    public static final String FILTER_NO_BUGS_RESPONSE_PROMPT = """
            Your task is to say whether bugs have been found in the review delimited by "'''".
            
            Your answer should be one of these two:
            """ + NO_BUGS_DETECTED + """ 
             - if it says in the review that no bugs have been found.
            " "(empty line) - in the review there are bugs described.
            """;

    public static final String FILTER_LOW_IMPACT_CHANGE_PROMPT = """
            Your task:
            Analyze the patch (code changes' metadata) delimited by "'''" and tell whether it makes sense to check exactly the changes made for bugs.
            Hint: Changes in the patch are marked with "+" (line added) or "-" (line deleted).
            
            Your answer should be ONLY "Yes" or "No":
            Yes - if it is worth reviewing these changes for bugs because they add/modify/remove functionality, logic, or behavior.
            No - if there is no need to check these changes for bugs since this is a simple modification such as:
            adding or removing empty lines, a change of access modifier, or renaming a variable, a method, a class, a directory, etc.
          
            """;

}
