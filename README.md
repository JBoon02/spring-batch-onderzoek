# Spring Batch Onderzoeksproject
 ## descriptie: Onderzoeksproject naar hoe spring batch werkt

Spring batch werkt op basis van:
- JobBuilderFacotory
    - = Om een jobs te definieren
    - Meestal word hiervoor een config klasse aangemaakt
- StepBuilderFactory
    - = Om de stappen te definieëren die worden gezet binnen een job
    - Elke step word voorzien van een Reader en Writer eventueel een Processor. 
> Reader: 
> 
> Leest gegevens in. 


> Processor
> 
> Verwekt de gegevens die ingelezen zijn door de reader. 

> Writer: 
> 
> Schrijft de verwerkte gegevens terug weg.

> Listener:
> 
> voorbeeld: StepExecutionListener
> 
> Dit is een interface die bij het implementeren verplicht om een 
> 
> ***@BeforeStep*** en ***@AfterStep*** te definieëren

! Er kan ook gebruikt worden gemaakt van een flow binnen een job waarbij 
  elke flow verschillende steps heeft. 

---

 - Binnen een job kan er op 2 manieren gewerkt worden: 
     - Via Chunks
     - Via Tasklets
 

## Tasklet
__source: zie onderaan sources "Information for Spring batch Tasklet vs. Chunks"__

= De bedoeling van tasklets is om één taak binnen één step te volbrengen. Elke step zou enkel één afgebakende taak behandelen. 

- LineReader implements Tasklet
- LinesProcesoor implements Tasklet
- LinesWriter implements Tasklet

**Tasklet** is een interface dus word de implementatie van execute geforceerd. 
Om **Job** te configureren eerst **Steps** configureren met **tasklets** erin. 

Serializable
---
Serialization betekend het omzetten van een Java Object naar een static stream van bytes, 
deze kan vervolgens worden opgeslagen in een database of worden overgezet over een netwerk. 
Dit is van belnag omdat indien Objecten worden overgezet tussen verschillende steps deze 
de **Serializable** interface moeten implementeren.

---

## Chunks
= Met deze aanpak worden acties uitgevoerd in chunks van data. In plaats van read, process
van alle rows in één keer gaat het een vast aantal (chunks) in één keer doen.
Dit gaat zo verder tot er geen data meer in de file aanwezig is. 

_Verschil met tasklet_ 
één step die één tasklet uitvoerd. 
Deze tasklet definieert een reader, writer, processor die over chunks van data werkt. 

- LineReader implements ItemReader<Line>
- LineWriter implements LineWriter<Writer>
- LineProcessor implements LineProcessor<Line, Line>

In dit project word er gebruikt gemaakt van de chunks methode

Sources
---

[Information for FlowBuilder](https://docs.spring.io/spring-batch/docs/current/api/org/springframework/batch/core/job/builder/flowbuilder.html)

[Information for Spring batch Tasklet vs. Chunks](https://www.baeldung.com/spring-batch-tasklet-chunk)

[Information for Serialization](https://www.baeldung.com/java-serialization)

[Information for Feign](https://www.baeldung.com/intro-to-feign)



