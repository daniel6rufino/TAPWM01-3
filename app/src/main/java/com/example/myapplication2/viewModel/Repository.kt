package com.example.myapplication2.viewModel

import com.example.myapplication2.roomDB.Pessoa
import com.example.myapplication2.roomDB.PessoaDataBase

class Repository(private val db : PessoaDataBase) {
    suspend fun upsertPessoa(pessoa: Pessoa){
        db.pessoaDao().upsertPessoa(pessoa)
    }

    suspend fun deletePessoa(pessoa: Pessoa){
        db.pessoaDao().deletePessoa(pessoa)
    }

    fun getAllPessoa() = db.pessoaDao().getAllPessoa()
}