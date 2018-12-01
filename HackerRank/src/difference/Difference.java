package difference;

class Difference {
    private int[] elements;
    public int maximumDifference;

    public Difference(int[] a) {
        elements = a;
    }
    public int computeDifference(){

        int tempDifference;
        for (int i = 0; i < elements.length; i++) {
            for (int j = i+1; j < elements.length; j++) {
                tempDifference = Math.abs(elements[i] - elements[j]);
                if (tempDifference > maximumDifference)
                    maximumDifference = tempDifference;
            }
        }
                return maximumDifference;
    }
}
