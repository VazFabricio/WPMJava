public class Calculator {


    public int wpm(double end, double start, int charSize){
        double totalTime = end-start;
        double seconds = totalTime / 1000000000.0;
        //wdp = (x characters / 5 ) / 1min = y WPM
        return (int) ((((double) charSize / 5) / seconds) * 60);
    }
}
