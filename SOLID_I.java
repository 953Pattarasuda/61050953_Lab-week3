import javax.print.Doc;

class Document
{
}

interface Machine
{
    void print(Document d);
    void fax(Document d) throws Exception;
    void scan(Document d) throws Exception;
}

class MultiFunctionPrinter implements Machine
{
    @Override
    public void print(Document d) {}

    @Override
    public void fax(Document d) {}

    @Override
    public void scan(Document d) {}
}

class OldFashionPrinter implements Machine
{
    @Override
    public void print(Document d) {}

    @Override
    public void fax(Document d) 
    {
        throw new NotImplementedException();
    }

    @Override
    public void scan(Document d) 
    {
        throw new NotImplementedException();
    } 

}

//

interface Printer
{
    void print(Document d);
}

interface Scanner
{
    void scan(Document d);
}

interface Fax
{
    void fax(Document d);
}

class JustAPrinter implements Printer
{
    @Override
    public void print(Document d){}
}

class Photocopier implements Printer, Scanner
{
    @Override
    public void print(Document d) {}
    
    @Override
    public void scan(Document d) {}
}

interface MultiFunctionDevice extends Printer, Scanner
{

}

class MultiFunctionMachine implements MultiFunctionDevice
{
    private Printer printer;
    private Scanner scanner;

    public MultiFunctionMachine(Printer printer, Scanner scanner)
    {
        this.printer = printer;
        this.scanner = scanner;
    }
    @Override
    public void print(Document d) 
    {
        printer.print(d);
    }

    @Override
    public void scan(Document d) 
    {
        scanner.scan(d);
    }

    public class SOLID_I
    {

    }
}