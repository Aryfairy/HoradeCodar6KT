//Agenda
//Considerando a necessidade de desenvolver uma agenda que contenha nomes, endereços e telefones de 10 pessoas, defina a estrutura de registro apropriada, o diagrama de blocos e a codificação de um programa que por meio do uso de um menu de opções, execute as seguintes etapas:
//
//a) Cadastrar os 10 registros.
//b) Pesquisar um dos 10 registros de cada vez pelo campo nome (usar o método seqüencial).
//c) Classificar por ordem de nome os registros cadastrados.
//d) Apresentar todos os registros.
//e) Sair do programa de cadastro.

fun main() {
    val agenda = mutableListOf<Array<String>>()

    while (true) {
        println("\nEscolha uma opção:")
        println("1) Cadastrar")
        println("2) Pesquisar")
        println("3) Classificar")
        println("4) Apresentar")
        println("5) Sair")
        print("Opção: ")

        when (readln().toIntOrNull()) {
            1 -> cadastrarRegistros(agenda)
            2 -> pesquisarPorNome(agenda)
            3 -> classificarPorNome(agenda)
            4 -> apresentarRegistros(agenda)
            5 -> {
                println("Fechando a agenda...")
                return
            }

            else -> println("Opção inválida, tente novamente.")
        }
    }
}

fun cadastrarRegistros(agenda: MutableList<Array<String>>) {
    if (agenda.size >= 10) {
        println("A agenda já tem 10 contatos cadastrados!")
        return
    }

    print("Nome: ")
    val nome = readln()
    print("Endereço: ")
    val endereco = readln()
    print("Telefone: ")
    val telefone = readln()

    agenda.add(arrayOf(nome, endereco, telefone))
    println("Contato cadastrado!")
}


fun pesquisarPorNome(agenda: List<Array<String>>) {
    print("Nome do contato: ")
    val nomeBusca = readln()

    val contato = agenda.find { it[0].equals(nomeBusca, ignoreCase = true) }
    if (contato != null) {
        println("Nome: ${contato[0]}, Endereço: ${contato[1]}, Telefone: ${contato[2]}")
    } else {
        println("Contato não encontrado!")
    }
}


fun classificarPorNome(agenda: MutableList<Array<String>>) {
    agenda.sortBy { it[0].lowercase() }
    println("Contatos ordenados por nome!")

}


fun apresentarRegistros(agenda: List<Array<String>>) {
    if (agenda.isEmpty()) {
        println("Nenhum contato cadastrado!")
    } else {
        println("\nLista de contatos:")
        agenda.forEach { println("Nome: ${it[0]}, Endereço: ${it[1]}, Telefone: ${it[2]}") }
    }
}
