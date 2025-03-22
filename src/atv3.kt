//Nome e Altura
//Elaborar um programa que armazene o nome e a altura de 15 pessoas, por meio do uso de
//registros. O programa deverá ser manipulado por um menu que execute as seguintes etapas:
//
//a) Cadastrar os 15 registros.
//b) Apresentar os registros (nome e altura) das pessoas menores ou iguais a 1.5m.
//c) Apresentar os registros (nome e altura) das pessoas que sejam maiores que 1.5m.
//d) Apresentar os registros (nome e altura) das pessoas que sejam maiores que 1.5m e menores que
//2.0m.
//e) Apresentar a média extraída de todas as alturas armazenadas.
//f) Sair do programa.
// Main.kt
fun main() {
    val pessoas = mutableListOf<Pessoa>()  // Lista de pessoas

    while (true) {
        println("\nEscolha uma opção:")
        println("1) Cadastrar pessoas")
        println("2) Apresentar pessoas com altura <= 1.5m")
        println("3) Apresentar pessoas com altura > 1.5m")
        println("4) Apresentar pessoas com altura entre 1.5m e 2.0m")
        println("5) Apresentar a média de todas as alturas")
        println("6) Sair")
        print("Opção: ")

        val opcao = readln().toIntOrNull()  // Lê a opção do menu
        when (opcao) {
            1 -> cadastrarPessoa(pessoas)
            2 -> apresentarMenorOuIgual15m(pessoas)
            3 -> apresentarMaiorQue15m(pessoas)
            4 -> apresentarEntre15e20m(pessoas)
            5 -> calcularMediaAlturas(pessoas)
            6 -> {
                println("Fechando o programa...")
                break
            }
            else -> println("Opção inválida, tente novamente.")
        }
    }
}

fun cadastrarPessoa(pessoas: MutableList<Pessoa>) {
    if (pessoas.size >= 15) {
        println("Já foram cadastradas 15 pessoas!")
        return
    }

    print("Nome: ")
    val nome = readln()  // Lê o nome da pessoa
    print("Altura: ")
    val altura = readln().toFloatOrNull()  // Lê a altura, se não for um número, repete a entrada

    if (altura != null) {
        pessoas.add(Pessoa(nome, altura))  // Adiciona a pessoa na lista
        println("Pessoa cadastrada com sucesso!")
    } else {
        println("Altura inválida! Por favor, insira um valor numérico.")
    }
}

fun apresentarMenorOuIgual15m(pessoas: List<Pessoa>) {
    val resultado = pessoas.filter { it.isMenorOuIgual15m() }
    if (resultado.isEmpty()) {
        println("Nenhuma pessoa com altura menor ou igual a 1.5m!")
    } else {
        println("\nPessoas com altura menor ou igual a 1.5m:")
        for (pessoa in resultado) {
            println("Nome: ${pessoa.nome}, Altura: ${pessoa.altura}")
        }
    }
}

fun apresentarMaiorQue15m(pessoas: List<Pessoa>) {
    val resultado = pessoas.filter { it.isMaiorQue15m() }
    if (resultado.isEmpty()) {
        println("Nenhuma pessoa com altura maior que 1.5m!")
    } else {
        println("\nPessoas com altura maior que 1.5m:")
        for (pessoa in resultado) {
            println("Nome: ${pessoa.nome}, Altura: ${pessoa.altura}")
        }
    }
}

fun apresentarEntre15e20m(pessoas: List<Pessoa>) {
    val resultado = pessoas.filter { it.isEntre15e20m() }
    if (resultado.isEmpty()) {
        println("Nenhuma pessoa com altura entre 1.5m e 2.0m!")
    } else {
        println("\nPessoas com altura entre 1.5m e 2.0m:")
        for (pessoa in resultado) {
            println("Nome: ${pessoa.nome}, Altura: ${pessoa.altura}")
        }
    }
}

fun calcularMediaAlturas(pessoas: List<Pessoa>) {
    if (pessoas.isEmpty()) {
        println("Nenhuma pessoa cadastrada para calcular a média.")
        return
    }

    var somaAlturas = 0f
    for (pessoa in pessoas) {
        somaAlturas += pessoa.altura  // Soma manual das alturas
    }

    val media = somaAlturas / pessoas.size
    println("\nMédia das alturas: %.2f".format(media))
}
