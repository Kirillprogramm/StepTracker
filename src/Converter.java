public class Converter {

    double distanceInKilometres(int sumStepMonth){
        double distanceStep = 0.00075;
        return sumStepMonth * distanceStep;
    }
    double cCal(int sumStepMonth){
        double oneStep = 0.05;
        return  sumStepMonth * oneStep;
    }
}
