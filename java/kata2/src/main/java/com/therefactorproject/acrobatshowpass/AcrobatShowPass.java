package com.therefactorproject.acrobatshowpass;

public class AcrobatShowPass {
    private final String name;
    private final double basePrice;
    private final double taxRate;
    private double tax;
    private double totalPrice;

    public AcrobatShowPass(String name, double basePrice, double taxRate) {
        this.name = name;
        this.basePrice = basePrice;
        this.taxRate = taxRate;
    }

    public void printAndArchive(int printerId) {
        System.out.println("🎟️ Printing on Acrobat Show printer #" + printerId);
        System.out.println("Show: " + name);

        this.tax = this.basePrice * (this.taxRate / 100);
        this.totalPrice = this.basePrice + this.tax;

        System.out.println("======================");
        System.out.printf(java.util.Locale.US, "Base price: %.2f€\n", basePrice);
        System.out.printf(java.util.Locale.US, "Tax: %.2f€\n", tax);
        System.out.printf(java.util.Locale.US, "TOTAL: %.2f€\n", totalPrice);

        System.out.println("🤸 Archiving Acrobat Show pass of " + name + " in the circus records...");
    }
}
