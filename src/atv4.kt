//Funcionários
//Considerando os registros de 20 funcionários, contendo os campos: matrícula, nome e salário,
//desenvolver um programa que, por meio de um menu, execute as seguintes etapas:
//
//a) Cadastrar os 20 empregados e classificar os registros por número de matrícula.
//b) Pesquisar um determinado empregado pelo número de matrícula.
//c) Apresentar de forma ordenada (por matrícula) os registros dos empregados que recebem salários
//acima de R$1.000,00.
//d) Apresentar de forma ordenada (por matrícula) os registros dos empregados que recebem salários
//abaixo de R$1.000,00.
//e) Apresentar de forma ordenada (por matrícula) os registros dos empregados que recebem salários
//iguais a R$1.000,00.
//f) Sair do programa.

fun main() {
    val funcionarios = mutableListOf<Funcionario>()

    while (true) {
        println("\nEscolha uma opção:")
        println("1) Cadastrar funcionários")
        println("2) Pesquisar funcionário por matrícula")
        println("3) Apresentar funcionários com salário acima de R$1.000")
        println("4) Apresentar funcionários com salário abaixo de R$1.000")
        println("5) Apresentar funcionários com salário igual a R$1.000")
        println("6) Sair")
        print("Opção: ")

        val opcao = readln().toIntOrNull()
        when (opcao) {
            1 -> cadastrarFuncionario(funcionarios)
            2 -> pesquisarFuncionario(funcionarios)
            3 -> apresentarSalarioAcimaDe1000(funcionarios)
            4 -> apresentarSalarioAbaixoDe1000(funcionarios)
            5 -> apresentarSalarioIgualA1000(funcionarios)
            6 -> {
                println("Fechando o programa...")
                break
            }
            else -> println("Opção inválida, tente novamente.")
        }
    }
}

fun cadastrarFuncionario(funcionarios: MutableList<Funcionario>) {
    if (funcionarios.size >= 20) {
        println("Já foram cadastrados 20 funcionários!")
        return
    }

    print("Matrícula: ")
    val matricula = readln().toInt()
    print("Nome: ")
    val nome = readln()
    print("Salário: ")
    val salario = readln().toDoubleOrNull()

    if (salario != null) {
        funcionarios.add(Funcionario(matricula, nome, salario))
        funcionarios.sortBy { it.matricula }
        println("Funcionário cadastrado com sucesso!")
    } else {
        println("Salário inválido! Por favor, insira um valor numérico.")
    }
}

fun pesquisarFuncionario(funcionarios: List<Funcionario>) {
    print("Número da matrícula: ")
    val matriculaBusca = readln().toInt()

    val funcionario = funcionarios.find { it.matricula == matriculaBusca }
    if (funcionario != null) {
        println("Matrícula: ${funcionario.matricula}, Nome: ${funcionario.nome}, Salário: R$${"%.2f".format(funcionario.salario)}")
    } else {
        println("Funcionário não encontrado!")
    }
}

fun apresentarSalarioAcimaDe1000(funcionarios: List<Funcionario>) {
    val resultado = funcionarios.filter { it.salarioAcimaDe1000() }
    if (resultado.isEmpty()) {
        println("Nenhum funcionário com salário acima de R$1.000!")
    } else {
        println("\nFuncionários com salário acima de R$1.000:")
        for (funcionario in resultado) {
            println("Matrícula: ${funcionario.matricula}, Nome: ${funcionario.nome}, Salário: R$${"%.2f".format(funcionario.salario)}")
        }
    }
}

fun apresentarSalarioAbaixoDe1000(funcionarios: List<Funcionario>) {
    val resultado = funcionarios.filter { it.salarioAbaixoDe1000() }
    if (resultado.isEmpty()) {
        println("Nenhum funcionário com salário abaixo de R$1.000!")
    } else {
        println("\nFuncionários com salário abaixo de R$1.000:")
        for (funcionario in resultado) {
            println("Matrícula: ${funcionario.matricula}, Nome: ${funcionario.nome}, Salário: R$${"%.2f".format(funcionario.salario)}")
        }
    }
}

fun apresentarSalarioIgualA1000(funcionarios: List<Funcionario>) {
    val resultado = funcionarios.filter { it.salarioIgualA1000() }
    if (resultado.isEmpty()) {
        println("Nenhum funcionário com salário igual a R$1.000!")
    } else {
        println("\nFuncionários com salário igual a R$1.000:")
        for (funcionario in resultado) {
            println("Matrícula: ${funcionario.matricula}, Nome: ${funcionario.nome}, Salário: R$${"%.2f".format(funcionario.salario)}")
        }
    }
}