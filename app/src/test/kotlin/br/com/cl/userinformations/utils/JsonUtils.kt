package br.com.cl.userinformations.utils

import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Path

fun readJson(path: String): String {
    val defaultPath = "src/test/resources"
    val file = """${defaultPath}/${path}"""
    val formatedPath: Path = Path.of(file)
    return Files.readString(formatedPath, StandardCharsets.UTF_8)
}