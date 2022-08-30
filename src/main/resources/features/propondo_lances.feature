#language: pt
Funcionalidade: Propondo lances ao leilao

Cenario: Propondo um unico lance unico
Dado um lanche valido
Quando propoe o lance
Então o lance eh aceito

Cenario: Propondo varios lances validos
Dado um lance de 10.0 reais do usuario "fulano"
E um lance de 15.0 reais do usuario "beltrano"
Quando quando propoe varios lances ao leilao
Então o lances sao aceitos

