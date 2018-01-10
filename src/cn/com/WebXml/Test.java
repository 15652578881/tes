package cn.com.WebXml;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

public class Test {
	public static void main(String[] args) throws ServiceException,
    RemoteException {
WeatherWebServiceLocator locator = new WeatherWebServiceLocator();
WeatherWebServiceSoapStub service = (WeatherWebServiceSoapStub) locator
        .getPort(WeatherWebServiceSoapStub.class);
invokeGetSupportProvince(service);
System.out.println("...................");
invokeGetSupportCity(service);
invokeGetWeatherByOneCity(service);
}

// ���û�ȡ֧�ֵ�ʡ�ݡ��ݽӿ�
public static void invokeGetSupportProvince(
    WeatherWebServiceSoapStub service) throws RemoteException {
String[] provices = service.getSupportProvince();
System.out.println("�ܹ�" + provices.length + "��");
int count = 0;
for (String str : provices) {
    if (0 != count && count % 5 == 0) {
        System.out.println();
    }
    System.out.print(str + "\t");
    count++;
}
}

// ���û�ȡ֧�ֲ�ѯĳ��ʡ���ڵĳ��нӿ�
public static void invokeGetSupportCity(WeatherWebServiceSoapStub service)
    throws RemoteException {
String provinceName = "����";
String[] cities = service.getSupportCity(provinceName);
System.out.println("�ܹ�" + cities.length + "����");
for (int i = 0; i < cities.length; i++) {
    if (0 != i && i % 5 == 0) {
        System.out.println();
    }
    System.out.print(cities[i] + "\t");
}
}

// ���ò�ѯĳ�����������Ľӿ�
public static void invokeGetWeatherByOneCity(
    WeatherWebServiceSoapStub service) throws RemoteException {
String cityName = "֣��";
String[] weatherInfo = service.getWeatherbyCityName(cityName);
for (String str : weatherInfo) {
    System.out.println(str);
}
}
}
