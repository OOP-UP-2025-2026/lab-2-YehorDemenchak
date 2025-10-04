package ua.opnu;


public class TimeSpan {

    private int hours;
    private int minutes;

    TimeSpan(int hours, int minutes) {
        if (hours < 0 || minutes < 0) {
            throw new IllegalArgumentException("Time span can't be negative");
        }

        if (minutes > 59) {
            throw new IllegalArgumentException("Minutes can be between 0 and 59");
        }

        this.hours = hours;
        this.minutes = minutes;
    }

    int getHours() {
        return this.hours;
    }

    int getMinutes() {
        return this.minutes;
    }

    void add(int hours, int minutes) {
        if (hours < 0 || minutes < 0) {
            throw new IllegalArgumentException("Time span can't be negative");
        }

        if (minutes > 59) {
            throw new IllegalArgumentException("Minutes can be between 0 and 59");
        }

        this.minutes += minutes;
        this.hours += hours;

        if (this.minutes > 59) {
            this.hours += this.minutes / 60;
            this.minutes = this.minutes % 60;
        }
    }

    void addTimeSpan(TimeSpan timespan) {
        add(timespan.getHours(), timespan.getMinutes());
    }

    double getTotalHours() {
        return this.hours + (this.minutes / 60.0);
    }

    int getTotalMinutes() {
        return this.hours * 60 + this.minutes;
    }

    void subtract(TimeSpan span) {
        int currentTotalMinutes = this.getTotalMinutes();
        int spanTotalMinutes = span.getTotalMinutes();

        if (spanTotalMinutes > currentTotalMinutes) {
            throw new IllegalArgumentException("Can't subtract larger timespan from smaller one");
        }

        int resultMinutes = currentTotalMinutes - spanTotalMinutes;

        this.hours = resultMinutes / 60;
        this.minutes = resultMinutes % 60;
    }

    void scale(int factor) {
        if (factor <= 0) {
            throw new IllegalArgumentException("Factor must be greater than zero");
        }

        int totalMinutes = this.getTotalMinutes();
        totalMinutes *= factor;

        this.hours = totalMinutes / 60;
        this.minutes = totalMinutes % 60;
    }
}
