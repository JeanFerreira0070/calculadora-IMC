import java.util.InputMismatchException;
import java.util.Scanner;

public class PrincipalIMC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double peso = 0;
        double altura = 0;

        boolean inputValido = false;
        while (!inputValido) {
            try {
                System.out.println("Digite seu peso em kg:");
                peso = scanner.nextDouble();
                if (peso <= 0) {
                    System.out.println("Erro: O peso deve ser maior que zero.");
                } else {
                    inputValido = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: Por favor, digite um número válido para o peso.");
                scanner.next();
            }
        }

        inputValido = false;
        while (!inputValido) {
            try {
                System.out.println("Digite sua altura em metros:");
                altura = scanner.nextDouble();
                if (altura <= 0) {
                    System.out.println("Erro: A altura deve ser maior que zero.");
                } else {
                    inputValido = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: Por favor, digite um número válido para a altura.");
                scanner.next();
            }
        }

        IMC imc = new IMC(peso, altura);
        imc.exibirMassa();

        scanner.close();
    }
}

class IMC {
    private double altura;
    private double peso;
    private double massaCorporal;

    public IMC(double peso, double altura) {
        this.altura = altura;
        this.peso = peso;
        calcularMassa();
    }

    public double getMassaCorporal() {
        return massaCorporal;
    }

    public void setMassaCorporal(double massaCorporal) {
        this.massaCorporal = massaCorporal;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void calcularMassa(){
        massaCorporal =  peso / (altura * altura);
    }

    public void exibirMassa(){
        System.out.println("Sua massa corporal é: " + massaCorporal);
        if (massaCorporal < 16.9){
            System.out.println("Muito abaixo do peso");
        } else if (massaCorporal >= 17 && massaCorporal <= 18.4) {
            System.out.println("Abaixo do peso");
        }
        else if (massaCorporal >= 18.5 && massaCorporal <= 24.9) {
            System.out.println("Peso normal");
        }
        else if (massaCorporal >= 25 && massaCorporal <= 29.9) {
            System.out.println("Acima do peso");
        }
        else if (massaCorporal >= 30 && massaCorporal <= 34.9) {
            System.out.println("Obesidade grau I");
        }
        else if (massaCorporal >= 35 && massaCorporal <= 40) {
            System.out.println("Obesidade grau II");
        }
        else if (massaCorporal > 40 ) {
            System.out.println("Obesidade grau III");
        }
    }
}