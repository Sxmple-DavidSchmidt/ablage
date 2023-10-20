import java.util.HashMap;
import java.util.Map;

public class Main {
    public static boolean isSet(Map<String,ArgumentValue> argumentMap, String parameter) {
        if (!argumentMap.containsKey(parameter)) return false;
        return argumentMap.get(parameter) != null;
    }

    public static ArgumentValue getArgument(Map<String,ArgumentValue> argumentMap, String parameter) {
        return argumentMap.getOrDefault(parameter, null);
    }

    public static void printSetArguments(Map<String, ArgumentValue> argumentMap) {
        for (Map.Entry<String, ArgumentValue> entry : argumentMap.entrySet()) {
            ArgumentValue value = entry.getValue();
            if (value != null) {
                System.out.println(entry.getKey() + ": " + value.value);
            }
        }
    }

    public static void main(String[] args) {
        Map<String, ArgumentValue> arguments = new HashMap<>();
        arguments.put("alpha", null);
        arguments.put("beta", null);
        arguments.put("gamma", null);

        String state = null;

        for (int i = 0; i < args.length; i++) {
            String carg = args[i];

            if (state == null) {
                if (!carg.startsWith("-")) {
                    System.err.println("No parameter name given");
                    System.exit(-1);
                } else {
                    if (carg.equals("-a") || carg.equals("--alpha")) {
                        state = "alpha";
                    } else if (carg.equals("-b") || carg.equals("--beta")) {
                        state = "beta";
                    } else if (carg.equals("-g") || carg.equals("--gamma")) {
                        state = "gamma";
                    } else {
                        System.err.println("Invalid parameter provided");
                        System.exit(-1);
                    }
                }
            } else if (state.equals("alpha")) {
                if (carg.startsWith("-")) {
                    System.err.println("No value given for alpha");
                    System.exit(-1);
                } else {
                    if (arguments.get(state) != null) {
                        System.err.println("Can only set parameter once");
                        System.exit(-1);
                    } else {
                        arguments.put(state, new ArgumentValue<Integer>(Integer.parseInt(carg)));
                    }
                }

                state = null;
            } else if (state.equals("beta")) {
                if (carg.startsWith("-")) {
                    System.err.println("No value given for beta");
                    System.exit(-1);
                } else {
                    if (arguments.get(state) != null) {
                        System.err.println("Can only set parameter once");
                        System.exit(-1);
                    } else {
                        arguments.put(state, new ArgumentValue<Float>(Float.parseFloat(carg)));
                    }
                }

                state = null;
            } else if (state.equals("gamma")) {
                if (carg.startsWith("-")) {
                    if (arguments.get(state) != null) {
                        System.err.println("Can only set parameter once");
                        System.exit(-1);
                    } else {
                        arguments.put(state, new ArgumentValue<String>(""));
                        i--;
                    }
                } else {
                    if (arguments.get(state) != null) {
                        System.err.println("Can only set parameter once");
                        System.exit(-1);
                    } else {
                        arguments.put(state, new ArgumentValue<String>(carg));
                    }
                }

                state = null;
            }
        }

        printSetArguments(arguments);
    }
}
