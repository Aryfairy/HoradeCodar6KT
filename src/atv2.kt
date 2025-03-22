fun main() {
    val alunos = mutableListOf<Aluno>()

    while (true) {
        println("\nEscolha uma opção:")
        println("1) Cadastrar alunos")
        println("2) Pesquisar aluno")
        println("3) Apresentar todos os alunos")
        println("4) Sair")
        print("Opção: ")

        val opcao = readln().toIntOrNull()
        when (opcao) {
            1 -> cadastrarAlunos(alunos)
            2 -> pesquisarAluno(alunos)
            3 -> apresentarAlunos(alunos)
            4 -> {
                println("Programa encerrado")
                break
            }
            else -> println("Opção inválida, tente novamente.")
        }
    }
}

fun cadastrarAlunos(alunos: MutableList<Aluno>) {
    if (alunos.size >= 20) {
        println("Todos os 20 alunos já foram cadastrados!")
        return
    }

    print("Nome: ")
    val nome = readln()

    // Tratamento para garantir que as notas sejam entradas válidas
    val nota1 = solicitarNota()
    val nota2 = solicitarNota()
    val nota3 = solicitarNota()
    val nota4 = solicitarNota()

    alunos.add(Aluno(nome, nota1, nota2, nota3, nota4))
    alunos.sortBy { it.nome.lowercase() }
    println("Aluno cadastrado e lista ordenada!")
}

fun solicitarNota(): Float {
    while (true) {
        print("Nota (0 a 10): ")
        val nota = readln().toFloatOrNull()
        if (nota != null && nota in 0f..10f) {
            return nota
        } else {
            println("Nota inválida! Por favor, insira um valor entre 0 e 10.")
        }
    }
}

fun pesquisarAluno(alunos: List<Aluno>) {
    print("Nome do aluno: ")
    val nomeBusca = readln()

    val aluno = alunos.find { it.nome.equals(nomeBusca, ignoreCase = true) }
    if (aluno != null) {
        println("Nome: ${aluno.nome}, Média: %.2f, Situação: ${aluno.situacao()}".format(aluno.media()))
    } else {
        println("Aluno não encontrado!")
    }
}

fun apresentarAlunos(alunos: List<Aluno>) {
    if (alunos.isEmpty()) {
        println("Nenhum aluno cadastrado!")
        return
    }

    println("\nLista de alunos:")
    for (aluno in alunos) {
        println("Nome: ${aluno.nome}, Média: %.2f, Situação: ${aluno.situacao()}".format(aluno.media()))
    }
}