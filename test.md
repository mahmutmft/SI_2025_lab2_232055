## Објаснување на unit тестовите

Во Every Statement тест случаите прво имаме анотација `@Test` која означува дека методот е тест.

За секој тест случај, во функцијата:

* Правиме листа и ставаме податоци кои сакаме да ги тестираме.
* Со променливата result го зачувуваме резултатот што би го добиле ако апликацијата се изврши со тие податоци.
* Потоа во assertEquals(x, result) проверуваме дали резултатот од методот е точен, односно дали result е еднаков на очекуваната вредност x.

Исто така, во Multiple Condition тест случаите, исто така правиме листа и ставаме различни податоци кои сакаме да ги тестираме. Со променливата result ја земаме вредноста што ја враќа методот за тие податоци, и ја споредуваме со точниот очекуван резултат со assertEquals(x, result).

Со ова се проверува дали методот работи правилно за различни влезни ситуации.

