package creational;

interface Gpu {
    void assemble();
}

interface Monitor {
    void assemble();
}

class MsiGpu implements Gpu {
    @Override
    public void assemble() {
        System.out.println("Assembling MSI GPU...");
    }
}

class AsusGpu implements Gpu {

    @Override
    public void assemble() {
        System.out.println("Assembling Asus Gpu....");
    }
}

class MsiMonitor implements Monitor {
    @Override
    public void assemble() {
        System.out.println("Assembling MSI Monitor...");
    }
}

class AsusMonitor implements Monitor {
    @Override
    public void assemble() {
        System.out.println("Assembling Asus Monitor....");
    }
}

abstract class Company {

    abstract Gpu createGpu();

    abstract Monitor createMonitor();
}

class MsiManufacturer extends Company {
    @Override
    Gpu createGpu() {
        Gpu gpu = new MsiGpu();
        gpu.assemble();

        System.out.println("Creating MSI GPU");
        return gpu;
    }

    @Override
    Monitor createMonitor() {
        Monitor monitor = new MsiMonitor();
        monitor.assemble();
        System.out.println("Creating MSI Monitor");
        return monitor;
    }
}

class AsusManufacturer extends Company {

    @Override
    Gpu createGpu() {
        Gpu gpu = new AsusGpu();
        gpu.assemble();
        System.out.println("Creating Asus GPU");
        return gpu;
    }

    @Override
    Monitor createMonitor() {
        Monitor monitor = new AsusMonitor();
        monitor.assemble();
        System.out.println("Creating Asus Monitor");
        return monitor;
    }
}

public class AbstractFactory {
    public static void main(String[] args) {
        Company msi = new MsiManufacturer();
        Gpu msiGpu = msi.createGpu();
        Monitor msiMonitor = msi.createMonitor();

        System.out.println(msiGpu);
        System.out.println(msiMonitor);

        Company asus = new AsusManufacturer();
        Gpu asusGpu = asus.createGpu();
        Monitor asusMonitor = asus.createMonitor();

        System.out.println(asusGpu);
        System.out.println(asusMonitor);

    }
}
