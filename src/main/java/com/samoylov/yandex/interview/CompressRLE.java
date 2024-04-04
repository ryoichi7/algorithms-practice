package com.samoylov.yandex.interview;

import java.util.HashMap;

public class CompressRLE {
    public String compress(String str){
        if (str == null || str.isBlank()){
            return "";
        }
        var curState = new HashMap<Character, Integer>();
        StringBuilder builder = new StringBuilder();
        for (var el : str.toCharArray()){
            if (curState.containsKey(el)) {
                curState.put(el, curState.get(el) + 1);
            } else {
                appendToResult(curState, builder);
                curState.put(el, 1);
            }
        }
        appendToResult(curState, builder);
        return builder.toString();
    }

    private void appendToResult(HashMap<Character, Integer> curState, StringBuilder builder) {
        if (!curState.isEmpty()) {
            var key = curState.keySet().stream().findFirst().get();
            var value = curState.values().stream().findFirst().get();
            builder.append(key);
            if (value > 1) {
                builder.append(value);
            }
            curState.clear();
        }
    }
}
