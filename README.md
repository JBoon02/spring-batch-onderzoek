*Spring Batch Onderzoeksproject
 **descriptie: Onderzoeksproject naar hoe spring batch werkt

Spring batch werkt op basis van:
- JobBuilderFacotory
    - = Om een jobs te definieren
    - Meestal word hiervoor een config klasse aangemaakt
- StepBuilderFactory
    - = Om de stappen te definieëren die worden gezet binnen een job
    - Elke step word voorzien van een Reader en Writer eventueel een Listener. 
> Reader: 
> m
> m

> Writer: 
> w
> r

> Listener:
> 

! Er kan ook gebruikt worden gemaakt van een flow binnen een job waarbij 
  elke flow verschillende steps heeft. 
------

 - Binnen een job kan er op 2 manieren gewerkt worden: 
     - Via Chunks
     - Via Tasklets
 

** 

In dit project is de steps approach genomen. Hiervoor is tevens ook een StepBuilderFactory nodig die 
de step gaat aanmaken die worden gebruikt in een job.


