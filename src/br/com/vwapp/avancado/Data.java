package br.com.vwapp.avancado;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Manipulação de Data e Hora
 *
 * As data são criadas por objetos do tipo Date e manipuladas por objetos do tipo Calendar.
 *
 * Tod o tempo em java é representado em milisegundos com o tipo Long
 * e esse tempo é medido a partir de 01 de Janeiro de 1970.
 */
public class Data {

    public static void main(String[] args) {

        objetoDate();
        objetoCalendar();
        formatacaoDeDatas();
        internacionalizacao();

    }

    static void objetoDate() {
        // Verifica quantos milisegundos já se passaram desde 01 de janeiro de 1970
        System.out.println(System.currentTimeMillis()); // 1543350894283 milisegundos

        // Pega a data atual
        Date agora = new Date();
        System.out.println(agora); // Tue Nov 27 18:37:39 BRST 2018


        // Pegar a data informado a quantidade de milisegundos
        Date data1 = new Date(1_000_000_000_000L);
        System.out.println(data1); // Sat Sep 08 22:46:40 BRT 2001

        // Pega a quantidade de milisegundos da data passada
        System.out.println(data1.getTime()); // 1000000000000

        // Definir um tempo em milisegundos
        data1.setTime(1_000_000_000_000L);

        // Comparar duas datas
        System.out.println(data1.compareTo(agora)); // -1 (data1 é antes de agora)
    }

    static void objetoCalendar() {
        // Retorna o calendário gregoriano (nosso calendario) na data de hoje
        Calendar calendar = Calendar.getInstance();

        // Retorna um objeto do tipo date
        System.out.println(calendar.getTime());

        // Definir uma data
        calendar.set(1980, Calendar.FEBRUARY, 12);
        System.out.println(calendar.getTime()); // Tue Feb 12 18:51:59 BRT 1980

        // Identificar o ano da data
        System.out.println(calendar.get(Calendar.YEAR)); // 1980
        System.out.println(calendar.get(Calendar.MONTH)); // 1 (0: janeiro, 1: fevereiro, ..., 11: dezembro)
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH)); // 12
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK)); // 3 (0: monday, 1: tuesday, 2: wednesday, 3: thursday, ...)
        System.out.println(calendar.get(Calendar.HOUR_OF_DAY)); // 19 horas
        System.out.println(calendar.get(Calendar.MINUTE)); // 17 minutos
        System.out.println(calendar.get(Calendar.SECOND)); // 28 segundos

        // Modificar algo da data
        calendar.set(Calendar.YEAR, 1923);
        calendar.set(Calendar.MONTH, Calendar.AUGUST);
        System.out.println(calendar.get(Calendar.YEAR)); // 1923
        System.out.println(calendar.get(Calendar.MONTH)); // 7

        // Limpar campos
        System.out.println(calendar.getTime()); // Sun Aug 12 19:03:13 BRT 1923
        calendar.clear(Calendar.SECOND);
        calendar.clear(Calendar.MINUTE);
        System.out.println(calendar.getTime()); // Sun Aug 12 19:00:00 BRT 1923

        // Modificar data em unidades (+ ou -), por exemplo, pegar o dia do mês e aumentar 20 unidades
        System.out.println(calendar.getTime()); // Sun Aug 12 19:00:00 BRT 1923
        calendar.add(Calendar.DAY_OF_MONTH, 20);
        System.out.println(calendar.getTime()); // Sat Sep 01 19:00:00 BRT 1923

        // Faz a mesma coisa do add() porém sem modificar o dado acima dele, ou seja, não modifica o mês
        calendar.roll(Calendar.DAY_OF_MONTH, -5);
        System.out.println(calendar.getTime()); // Wed Sep 26 19:00:00 BRT 1923
    }

    static void formatacaoDeDatas() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1993, Calendar.AUGUST, 21);

        Date data = calendar.getTime();
        System.out.println(data); // Sat Aug 21 19:25:29 BRT 1993

        // Formatação de datas
        DateFormat formataDatas = DateFormat.getDateInstance();
        System.out.println(formataDatas.format(data)); // 21/08/1993

        // Formatação de tempo
        DateFormat formataTempo = DateFormat.getTimeInstance();
        System.out.println(formataTempo.format(data)); // 19:26:34

        // Formatação de data e hora
        DateFormat formataDateTempo = DateFormat.getDateTimeInstance();
        System.out.println(formataDateTempo.format(data)); // 21/08/1993 19:27:11

        // Estilos
        formataDatas = DateFormat.getDateInstance(DateFormat.FULL);
        System.out.println(formataDatas.format(data)); // Sábado, 21 de Agosto de 1993
        formataDatas = DateFormat.getDateInstance(DateFormat.LONG);
        System.out.println(formataDatas.format(data)); // 21 de Agosto de 1993
        formataDatas = DateFormat.getDateInstance(DateFormat.MEDIUM);
        System.out.println(formataDatas.format(data)); // 21/08/1993
        formataDatas = DateFormat.getDateInstance(DateFormat.SHORT);
        System.out.println(formataDatas.format(data)); // 21/08/93

        // Tenta transformar uma string ou objeto em uma data
        try {
            Date date = formataDatas.parse("12/12/1980");
            System.out.println(date); // Fri Dec 12 00:00:00 BRT 1980
        } catch (ParseException error) {
            error.printStackTrace();
        }

        // Classe de formatação mais simples com padrões de formatação definido na documentação
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println(simpleDateFormat.format(data)); // 21/08/1993

        try {
            System.out.println(simpleDateFormat.parse("10/10/2010")); // Sun Oct 10 00:00:00 BRT 2010
        } catch (ParseException error) {
            error.printStackTrace();
        }

    }

    /**
     * Locale: Localização que define lingua, pais e costumes
     * Lingua: ISO 639
     * País ISO 3166
     */
    static void internacionalizacao() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1993, Calendar.AUGUST, 21);
        Date date = calendar.getTime();

        // Pega a localização de acordo com seu sistema operacional
        Locale padrao = Locale.getDefault();
        System.out.println(padrao); // pt_BR

        // Locale para o Brasil
        Locale brasil = new Locale("pt", "BR");
        System.out.println(brasil); // pt_BR

        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL, brasil);
        System.out.println(dateFormat.format(date)); // Sábado, 21 de Agosto de 1993

        // Locale para o EUA
        Locale ingles = Locale.US;
        System.out.println(ingles); // en_US


        dateFormat = DateFormat.getDateInstance(DateFormat.FULL, ingles);
        System.out.println(dateFormat.format(date)); // Saturday, August 21, 1993

        // Locale para o France
        Locale france = Locale.CANADA_FRENCH;
        System.out.println(france); // fr_CA


        dateFormat = DateFormat.getDateInstance(DateFormat.FULL, france);
        System.out.println(dateFormat.format(date)); // samedi 21 août 1993

    }

}
