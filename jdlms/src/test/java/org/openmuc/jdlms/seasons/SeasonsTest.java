// package org.openmuc.jdlms.seasons;
//
// import java.io.IOException;
// import java.net.InetAddress;
// import java.net.UnknownHostException;
// import java.util.Arrays;
//
// import org.junit.Test;
// import org.openmuc.jdlms.AttributeAddress;
// import org.openmuc.jdlms.HexConverter;
// import org.openmuc.jdlms.LnClientConnection;
// import org.openmuc.jdlms.ObisCode;
// import org.openmuc.jdlms.SetParameter;
// import org.openmuc.jdlms.TcpConnectionBuilder;
// import org.openmuc.jdlms.datatypes.CosemDateTime;
// import org.openmuc.jdlms.datatypes.CosemDateTime.ClockStatus;
// import org.openmuc.jdlms.datatypes.DataObject;
//
// public class SeasonsTest {
//
// @Test
// public void testSetting4Seasons() throws UnknownHostException, IOException {
//
// byte[] authenticationKey = HexConverter.fromShortHexString("");
// byte[] encryptionKey = HexConverter.fromShortHexString("");
//
// LnClientConnection lnConnection = new TcpConnectionBuilder(InetAddress.getByName("127.0.0.1")).tcpPort(4057)
// .logicalDeviceAddress(64)
// .clientAccessPoint(1)
// .useGmacAuthentication(authenticationKey, encryptionKey)
// .enableEncryption(encryptionKey)
// .buildLnConnection();
//
// lnConnection.set(set4Seasons());
//
// }
//
// public SetParameter set2Seasons() {
//
// final CosemDateTime dateTime1 = new CosemDateTime(2015, 9, 21, 2, 0, 0, 0x8000,
// ClockStatus.DAYLIGHT_SAVING_ACTIVE);
// final CosemDateTime dateTime2 = new CosemDateTime(2015, 3, 21, 1, 0, 0, 0x8000,
// ClockStatus.DAYLIGHT_SAVING_ACTIVE);
//
// final DataObject season1 = DataObject.newStructureData(
// Arrays.asList(DataObject.newOctetStringData(new byte[] { 115, 110, 97, 117, 116, 117, 109, 110 }),
// DataObject.newDateTimeData(dateTime1),
// DataObject.newOctetStringData(new byte[] { 119, 101, 101, 107, 112, 48, 48, 49 })));
//
// final DataObject season2 = DataObject.newStructureData(
// Arrays.asList(DataObject.newOctetStringData(new byte[] { 115, 110, 115, 112, 114, 105, 110, 103 }),
// DataObject.newDateTimeData(dateTime2),
// DataObject.newOctetStringData(new byte[] { 119, 101, 101, 107, 112, 48, 48, 49 })));
//
// final DataObject seasonList = DataObject.newArrayData((Arrays.asList(season2, season1)));
// final AttributeAddress setSeasonAttributeAddress = new AttributeAddress(20, new ObisCode("0.0.13.0.0.255"), 7);
// final SetParameter setParameter = new SetParameter(setSeasonAttributeAddress, seasonList);
//
// return setParameter;
// }
//
// public SetParameter set4Seasons() {
//
// final CosemDateTime dateTime1 = new CosemDateTime(2015, 9, 21, 2, 0, 0, 0x8000,
// ClockStatus.DAYLIGHT_SAVING_ACTIVE);
// final CosemDateTime dateTime2 = new CosemDateTime(2015, 3, 21, 1, 0, 0, 0x8000,
// ClockStatus.DAYLIGHT_SAVING_ACTIVE);
// final CosemDateTime dateTime3 = new CosemDateTime(2015, 6, 21, 2, 0, 0, 0x8000,
// ClockStatus.DAYLIGHT_SAVING_ACTIVE);
// final CosemDateTime dateTime4 = new CosemDateTime(2015, 12, 21, 1, 0, 0, 0x8000,
// ClockStatus.DAYLIGHT_SAVING_ACTIVE);
//
// final DataObject season3 = DataObject.newStructureData(
// Arrays.asList(DataObject.newOctetStringData(new byte[] { 115, 110, 115, 117, 109, 109, 101, 114 }),
// DataObject.newDateTimeData(dateTime3),
// DataObject.newOctetStringData(new byte[] { 119, 101, 101, 107, 112, 48, 48, 50 })));
//
// final DataObject season4 = DataObject.newStructureData(
// Arrays.asList(DataObject.newOctetStringData(new byte[] { 115, 110, 119, 105, 110, 116, 101, 114 }),
// DataObject.newDateTimeData(dateTime4),
// DataObject.newOctetStringData(new byte[] { 119, 101, 101, 107, 112, 48, 48, 50 })));
//
// final DataObject season1 = DataObject.newStructureData(
// Arrays.asList(DataObject.newOctetStringData(new byte[] { 115, 110, 97, 117, 116, 117, 109, 110 }),
// DataObject.newDateTimeData(dateTime1),
// DataObject.newOctetStringData(new byte[] { 119, 101, 101, 107, 112, 48, 48, 49 })));
//
// final DataObject season2 = DataObject.newStructureData(
// Arrays.asList(DataObject.newOctetStringData(new byte[] { 115, 110, 115, 112, 114, 105, 110, 103 }),
// DataObject.newDateTimeData(dateTime2),
// DataObject.newOctetStringData(new byte[] { 119, 101, 101, 107, 112, 48, 48, 49 })));
//
// final DataObject seasonList = DataObject.newArrayData((Arrays.asList(season1, season2, season3, season4)));
// final AttributeAddress setSeasonAttributeAddress = new AttributeAddress(20, new ObisCode("0.0.13.0.0.255"), 7);
// final SetParameter setParameter = new SetParameter(setSeasonAttributeAddress, seasonList);
//
// return setParameter;
// }
//
// }
