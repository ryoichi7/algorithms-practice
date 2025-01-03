package com.samoylov.yandex.practice.algorithms5.prac3;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Костя успешно прошел собеседование и попал на стажировку в отдел разработки сервиса «Музыка».
 * Конкретно ему поручили такое задание — научиться подбирать плейлист для группы друзей, родственников или коллег.
 * При этом нужно подобрать такой плейлист, в который входят исключительно нравящиеся всем членам группы песни.
 * Костя очень хотел выполнить это задание быстро и качественно, но у него не получается.
 * Помогите ему написать программу, которая составляет плейлист для группы людей.
 * ------------
 * Формат ввода
 * В первой строке расположено одно натуральное число
 * n
 * (1 ≤ n ≤ 2⋅10^5), где n – количество человек в группе.
 * В следующих 2⋅n строках идет описание любимых плейлистов членов группы.
 * По 2 строки на каждого участника.
 * В первой из этих 2-х строк расположено число Ki — количество любимых треков i-го члена группы.
 * В следующей строке расположено Ki строк через пробел — названия любимых треков i-го участника группы.
 * Каждый трек в плейлисте задан в виде строки, все строки уникальны, сумма длин строк не превосходит 2⋅10^6.
 * Строки содержат большие и маленькие латинские буквы и цифры.
 * ------------
 * Формат вывода
 * Выведите количество, а затем сам список песен через пробел — список треков,
 * которые нравятся каждому участнику группы.
 * Ответ необходимо отсортировать в лексикографическом порядке!
 */
public class Task1 {
    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            var trackOccurrences = new HashMap<String, Integer>();
            var peopleAmount = Integer.parseInt(reader.readLine());
            for (int i = 0; i < peopleAmount; ++i) {
                var tracksAmount = Integer.parseInt(reader.readLine());
                var tracks = reader.readLine().split(" ");
                for (String track : tracks) {
                    trackOccurrences.put(track, trackOccurrences.getOrDefault(track, 0) + 1);
                }
            }
            var trackSet = new HashSet<String>();
            for (var key : trackOccurrences.keySet()) {
                if (trackOccurrences.get(key) == peopleAmount) {
                    trackSet.add(key);
                }
            }
            var sortedTracks = new ArrayList<String>(trackSet);
            Collections.sort(sortedTracks);

            System.out.println(trackSet.size());
            System.out.println(String.join(" ", sortedTracks));
        }
    }
}
