import java.util.Scanner;


public class OceanTester extends AssignmentTester{
	
	private static final Position[][] p = {{new Position(0,0),new Position(0,1),new Position(0,2),new Position(0,3),new Position(0,4),
											new Position(0,5),new Position(0,6),new Position(0,7),new Position(0,8),new Position(0,9)},
											{new Position(1,0),new Position(1,1),new Position(1,2),new Position(1,3),new Position(1,4),
											new Position(1,5),new Position(1,6),new Position(1,7),new Position(1,8),new Position(1,9)},
											{new Position(2,0),new Position(2,1),new Position(2,2),new Position(2,3),new Position(2,4),
											new Position(2,5),new Position(2,6),new Position(2,7),new Position(2,8),new Position(2,9)},
											{new Position(3,0),new Position(3,1),new Position(3,2),new Position(3,3),new Position(3,4),
											new Position(3,5),new Position(3,6),new Position(3,7),new Position(3,8),new Position(3,9)},
											{new Position(4,0),new Position(4,1),new Position(4,2),new Position(4,3),new Position(4,4),
											new Position(4,5),new Position(4,6),new Position(4,7),new Position(4,8),new Position(4,9)},
											{new Position(5,0),new Position(5,1),new Position(5,2),new Position(5,3),new Position(5,4),
											new Position(5,5),new Position(5,6),new Position(5,7),new Position(5,8),new Position(5,9)},
											{new Position(6,0),new Position(6,1),new Position(6,2),new Position(6,3),new Position(6,4),
											new Position(6,5),new Position(6,6),new Position(6,7),new Position(6,8),new Position(6,9)},
											{new Position(7,0),new Position(7,1),new Position(7,2),new Position(7,3),new Position(7,4),
											new Position(7,5),new Position(7,6),new Position(7,7),new Position(7,8),new Position(7,9)},
											{new Position(8,0),new Position(8,1),new Position(8,2),new Position(8,3),new Position(8,4),
											new Position(8,5),new Position(8,6),new Position(8,7),new Position(8,8),new Position(8,9)},
											{new Position(9,0),new Position(9,1),new Position(9,2),new Position(9,3),new Position(9,4),
											new Position(9,5),new Position(9,6),new Position(9,7),new Position(9,8),new Position(9,9)}};
	
	private static final String[] boats =  {"hA00","hA01","hA02","hA03","hA04","hA05","hA06","hA07","hA08","hA09",
											"hA10","hA11","hA12","hA13","hA14","hA15","hA16","hA17","hA18","hA19",
											"hA20","hA21","hA22","hA23","hA24","hA25","hA26","hA27","hA28","hA29",
											"hA30","hA31","hA32","hA33","hA34","hA35","hA36","hA37","hA38","hA39",
											"hA40","hA41","hA42","hA43","hA44","hA45","hA46","hA47","hA48","hA49",
											"hA50","hA51","hA52","hA53","hA54","hA55","hA56","hA57","hA58","hA59",
											"hA60","hA61","hA62","hA63","hA64","hA65","hA66","hA67","hA68","hA69",
											"hA70","hA71","hA72","hA73","hA74","hA75","hA76","hA77","hA78","hA79",
											"hA80","hA81","hA82","hA83","hA84","hA85","hA86","hA87","hA88","hA89",
											"hA90","hA91","hA92","hA93","hA94","hA95","hA96","hA97","hA98","hA99",
											"vA00","vA01","vA02","vA03","vA04","vA05","vA06","vA07","vA08","vA09",
											"vA10","vA11","vA12","vA13","vA14","vA15","vA16","vA17","vA18","vA19",
											"vA20","vA21","vA22","vA23","vA24","vA25","vA26","vA27","vA28","vA29",
											"vA30","vA31","vA32","vA33","vA34","vA35","vA36","vA37","vA38","vA39",
											"vA40","vA41","vA42","vA43","vA44","vA45","vA46","vA47","vA48","vA49",
											"vA50","vA51","vA52","vA53","vA54","vA55","vA56","vA57","vA58","vA59",
											"vA60","vA61","vA62","vA63","vA64","vA65","vA66","vA67","vA68","vA69",
											"vA70","vA71","vA72","vA73","vA74","vA75","vA76","vA77","vA78","vA79",
											"vA80","vA81","vA82","vA83","vA84","vA85","vA86","vA87","vA88","vA89",
											"vA90","vA91","vA92","vA93","vA94","vA95","vA96","vA97","vA98","vA99",
											"hB00","hB01","hB02","hB03","hB04","hB05","hB06","hB07","hB08","hB09",
											"hB10","hB11","hB12","hB13","hB14","hB15","hB16","hB17","hB18","hB19",
											"hB20","hB21","hB22","hB23","hB24","hB25","hB26","hB27","hB28","hB29",
											"hB30","hB31","hB32","hB33","hB34","hB35","hB36","hB37","hB38","hB39",
											"hB40","hB41","hB42","hB43","hB44","hB45","hB46","hB47","hB48","hB49",
											"hB50","hB51","hB52","hB53","hB54","hB55","hB56","hB57","hB58","hB59",
											"hB60","hB61","hB62","hB63","hB64","hB65","hB66","hB67","hB68","hB69",
											"hB70","hB71","hB72","hB73","hB74","hB75","hB76","hB77","hB78","hB79",
											"hB80","hB81","hB82","hB83","hB84","hB85","hB86","hB87","hB88","hB89",
											"hB90","hB91","hB92","hB93","hB94","hB95","hB96","hB97","hB98","hB99",
											"vB00","vB01","vB02","vB03","vB04","vB05","vB06","vB07","vB08","vB09",
											"vB10","vB11","vB12","vB13","vB14","vB15","vB16","vB17","vB18","vB19",
											"vB20","vB21","vB22","vB23","vB24","vB25","vB26","vB27","vB28","vB29",
											"vB30","vB31","vB32","vB33","vB34","vB35","vB36","vB37","vB38","vB39",
											"vB40","vB41","vB42","vB43","vB44","vB45","vB46","vB47","vB48","vB49",
											"vB50","vB51","vB52","vB53","vB54","vB55","vB56","vB57","vB58","vB59",
											"vB60","vB61","vB62","vB63","vB64","vB65","vB66","vB67","vB68","vB69",
											"vB70","vB71","vB72","vB73","vB74","vB75","vB76","vB77","vB78","vB79",
											"vB80","vB81","vB82","vB83","vB84","vB85","vB86","vB87","vB88","vB89",
											"vB90","vB91","vB92","vB93","vB94","vB95","vB96","vB97","vB98","vB99",
											"hC00","hC01","hC02","hC03","hC04","hC05","hC06","hC07","hC08","hC09",
											"hC10","hC11","hC12","hC13","hC14","hC15","hC16","hC17","hC18","hC19",
											"hC20","hC21","hC22","hC23","hC24","hC25","hC26","hC27","hC28","hC29",
											"hC30","hC31","hC32","hC33","hC34","hC35","hC36","hC37","hC38","hC39",
											"hC40","hC41","hC42","hC43","hC44","hC45","hC46","hC47","hC48","hC49",
											"hC50","hC51","hC52","hC53","hC54","hC55","hC56","hC57","hC58","hC59",
											"hC60","hC61","hC62","hC63","hC64","hC65","hC66","hC67","hC68","hC69",
											"hC70","hC71","hC72","hC73","hC74","hC75","hC76","hC77","hC78","hC79",
											"hC80","hC81","hC82","hC83","hC84","hC85","hC86","hC87","hC88","hC89",
											"hC90","hC91","hC92","hC93","hC94","hC95","hC96","hC97","hC98","hC99",
											"vC00","vC01","vC02","vC03","vC04","vC05","vC06","vC07","vC08","vC09",
											"vC10","vC11","vC12","vC13","vC14","vC15","vC16","vC17","vC18","vC19",
											"vC20","vC21","vC22","vC23","vC24","vC25","vC26","vC27","vC28","vC29",
											"vC30","vC31","vC32","vC33","vC34","vC35","vC36","vC37","vC38","vC39",
											"vC40","vC41","vC42","vC43","vC44","vC45","vC46","vC47","vC48","vC49",
											"vC50","vC51","vC52","vC53","vC54","vC55","vC56","vC57","vC58","vC59",
											"vC60","vC61","vC62","vC63","vC64","vC65","vC66","vC67","vC68","vC69",
											"vC70","vC71","vC72","vC73","vC74","vC75","vC76","vC77","vC78","vC79",
											"vC80","vC81","vC82","vC83","vC84","vC85","vC86","vC87","vC88","vC89",
											"vC90","vC91","vC92","vC93","vC94","vC95","vC96","vC97","vC98","vC99",
											"hS00","hS01","hS02","hS03","hS04","hS05","hS06","hS07","hS08","hS09",
											"hS10","hS11","hS12","hS13","hS14","hS15","hS16","hS17","hS18","hS19",
											"hS20","hS21","hS22","hS23","hS24","hS25","hS26","hS27","hS28","hS29",
											"hS30","hS31","hS32","hS33","hS34","hS35","hS36","hS37","hS38","hS39",
											"hS40","hS41","hS42","hS43","hS44","hS45","hS46","hS47","hS48","hS49",
											"hS50","hS51","hS52","hS53","hS54","hS55","hS56","hS57","hS58","hS59",
											"hS60","hS61","hS62","hS63","hS64","hS65","hS66","hS67","hS68","hS69",
											"hS70","hS71","hS72","hS73","hS74","hS75","hS76","hS77","hS78","hS79",
											"hS80","hS81","hS82","hS83","hS84","hS85","hS86","hS87","hS88","hS89",
											"hS90","hS91","hS92","hS93","hS94","hS95","hS96","hS97","hS98","hS99",
											"vS00","vS01","vS02","vS03","vS04","vS05","vS06","vS07","vS08","vS09",
											"vS10","vS11","vS12","vS13","vS14","vS15","vS16","vS17","vS18","vS19",
											"vS20","vS21","vS22","vS23","vS24","vS25","vS26","vS27","vS28","vS29",
											"vS30","vS31","vS32","vS33","vS34","vS35","vS36","vS37","vS38","vS39",
											"vS40","vS41","vS42","vS43","vS44","vS45","vS46","vS47","vS48","vS49",
											"vS50","vS51","vS52","vS53","vS54","vS55","vS56","vS57","vS58","vS59",
											"vS60","vS61","vS62","vS63","vS64","vS65","vS66","vS67","vS68","vS69",
											"vS70","vS71","vS72","vS73","vS74","vS75","vS76","vS77","vS78","vS79",
											"vS80","vS81","vS82","vS83","vS84","vS85","vS86","vS87","vS88","vS89",
											"vS90","vS91","vS92","vS93","vS94","vS95","vS96","vS97","vS98","vS99",
											"hD00","hD01","hD02","hD03","hD04","hD05","hD06","hD07","hD08","hD09",
											"hD10","hD11","hD12","hD13","hD14","hD15","hD16","hD17","hD18","hD19",
											"hD20","hD21","hD22","hD23","hD24","hD25","hD26","hD27","hD28","hD29",
											"hD30","hD31","hD32","hD33","hD34","hD35","hD36","hD37","hD38","hD39",
											"hD40","hD41","hD42","hD43","hD44","hD45","hD46","hD47","hD48","hD49",
											"hD50","hD51","hD52","hD53","hD54","hD55","hD56","hD57","hD58","hD59",
											"hD60","hD61","hD62","hD63","hD64","hD65","hD66","hD67","hD68","hD69",
											"hD70","hD71","hD72","hD73","hD74","hD75","hD76","hD77","hD78","hD79",
											"hD80","hD81","hD82","hD83","hD84","hD85","hD86","hD87","hD88","hD89",
											"hD90","hD91","hD92","hD93","hD94","hD95","hD96","hD97","hD98","hD99",
											"vD00","vD01","vD02","vD03","vD04","vD05","vD06","vD07","vD08","vD09",
											"vD10","vD11","vD12","vD13","vD14","vD15","vD16","vD17","vD18","vD19",
											"vD20","vD21","vD22","vD23","vD24","vD25","vD26","vD27","vD28","vD29",
											"vD30","vD31","vD32","vD33","vD34","vD35","vD36","vD37","vD38","vD39",
											"vD40","vD41","vD42","vD43","vD44","vD45","vD46","vD47","vD48","vD49",
											"vD50","vD51","vD52","vD53","vD54","vD55","vD56","vD57","vD58","vD59",
											"vD60","vD61","vD62","vD63","vD64","vD65","vD66","vD67","vD68","vD69",
											"vD70","vD71","vD72","vD73","vD74","vD75","vD76","vD77","vD78","vD79",
											"vD80","vD81","vD82","vD83","vD84","vD85","vD86","vD87","vD88","vD89",
											"vD90","vD91","vD92","vD93","vD94","vD95","vD96","vD97","vD98","vD99"};

	
	protected AssignmentTestCase[] getCases()
	{
		AssignmentTestCase[] tests = new AssignmentTestCase[40];
		tests[0] = new OceanTestCase(buildFleet(new int[] {0,300,360,491,704,605,808}),new Position[] {p[0][0],p[0][1],p[0][2],p[0][3],p[0][4],p[0][5],p[0][6],p[0][7],p[0][8],p[0][9],p[5][5],p[9][0],p[8][0],p[7][0],p[6][0],p[9][1],p[9][2],p[5][4],p[5][3],p[9][3]});
		tests[1] = new OceanTestCase(buildFleet(new int[] {159,368,497,487,577,703,800}),new Position[] {p[9][9],p[8][9],p[7][9],p[6][9],p[5][9],p[9][8],p[8][8],p[7][8],p[6][8],p[9][7],p[8][7],p[7][7],p[6][7],p[0][0],p[2][3],p[1][3],p[0][1],p[0][3]});
		tests[2] = new OceanTestCase(buildFleet(new int[] {90,295,579,687,600,887}),new Position[]{p[9][0],p[9][1],p[9][2],p[9][3],p[9][5],p[9][6],p[9][7],p[9][9],p[8][9],p[0][3],p[0][1],p[8][8],p[0][2],p[9][4],p[7][9],p[8][8],p[9][8]});
		tests[3] = new OceanTestCase(buildFleet(new int[] {150,291,695,578,898,899,888,878,969}),new Position[] {p[5][0],p[6][0],p[7][0],p[8][0],p[9][0],p[9][1],p[9][2],p[9][3],p[9][5],p[7][8],p[6][9],p[7][9],p[8][8],p[8][9],p[9][6],p[9][7],p[9][4]});
		tests[4] = new OceanTestCase(buildFleet(new int[] {50,320,300,440,760,880,980,990,991,890}),new Position[] {p[0][0],p[1][0],p[2][0],p[3][0],p[4][0],p[5][0],p[6][0],p[7][0],p[8][0],p[9][0],p[0][1],p[1][1],p[2][1],p[3][1],p[4][1],p[5][1],p[6][1],p[7][1],p[8][1],p[9][1],p[5][2],p[5][3],p[5][4],p[4][2]});
		tests[5] = new OceanTestCase(buildFleet(new int[] {3,201,400,300,310,740,850,760}),new Position[] {p[0][0],p[1][0],p[2][0],p[3][0],p[4][0],p[5][0],p[6][0],p[7][0],p[8][0],p[9][0],p[0][3],p[0][4],p[0][5],p[0][6],p[0][2],p[5][1],p[5][3],p[0][2],p[0][7],p[5][2],p[9][9]});
		tests[6] = new OceanTestCase(buildFleet(new int[] {5, 206, 216, 417, 427, 729, 709, 729, 739, 832}),new Position[] {p[0][9],p[1][9],p[2][9],p[3][9],p[4][9],p[5][9],p[6][9],p[7][9],p[8][9],p[9][9],p[0][5],p[0][6],p[0][7],p[0][8],p[1][6],p[1][7],p[1][8],p[2][7],p[3][2],p[2][8],p[3][3]});
		tests[7] = new OceanTestCase(buildFleet(new int[] {100, 200, 434, 738, 877, 292}),new Position[] {p[0][0],p[2][0],p[4][0],p[0][1],p[4][1],p[3][3],p[3][4],p[3][5],p[3][6],p[3][7],p[2][5],p[2][8],p[3][8],p[4][8],p[5][8],p[6][8],p[7][7],p[7][3],p[7][7],p[7][8],p[9][2],p[9][3],p[9][4],p[9][5],p[9][6]});
		tests[8] = new OceanTestCase(buildFleet(new int[] {0, 220, 522, 738, 877, 292}),new Position[] {p[0][0],p[2][0],p[4][0],p[2][2],p[3][2],p[4][2],p[5][2],p[2][3],p[2][5],p[2][8],p[3][8],p[4][8],p[5][8],p[6][8],p[7][7],p[7][3],p[7][7],p[7][8],p[9][2],p[9][3],p[9][4],p[9][5],p[9][6]});
		tests[9] = new OceanTestCase(buildFleet(new int[] {0, 340, 522, 738, 877, 292}),new Position[] {p[0][0],p[2][0],p[4][0],p[2][2],p[3][2],p[4][2],p[5][2],p[2][3],p[2][5],p[2][8],p[3][8],p[4][8],p[5][8],p[6][8],p[7][7],p[7][3],p[7][7],p[7][8],p[9][2],p[9][3],p[9][4],p[9][5],p[9][6]});
		tests[10] = new OceanTestCase(buildFleet(new int[] {5, 307, 369, 743, 490, 803}),new Position[] {p[0][2],p[0][3],p[0][4],p[0][5],p[0][6],p[0][7],p[0][8],p[0][9],p[3][7],p[4][3],p[5][3],p[7][3],p[9][0],p[9][1],p[9][2],p[9][3],p[5][9],p[6][9],p[7][9],p[8][9],p[9][9]});
		tests[11] = new OceanTestCase(buildFleet(new int[] {5, 307, 369, 743, 452, 490, 803}),new Position[] {p[0][2],p[0][3],p[0][4],p[0][5],p[0][6],p[0][7],p[0][8],p[0][9],p[3][7],p[4][3],p[5][3],p[7][3],p[9][0],p[9][1],p[9][2],p[9][3],p[5][9],p[6][9],p[7][9],p[8][9],p[9][9],p[5][2],p[5][3]});
		tests[12] = new OceanTestCase(buildFleet(new int[] {5, 307, 369, 743, 452, 461, 490, 803, }),new Position[] {p[0][2],p[0][3],p[0][4],p[0][5],p[0][6],p[0][7],p[0][8],p[0][9],p[3][7],p[4][3],p[5][3],p[7][3],p[9][0],p[9][1],p[9][2],p[9][3],p[5][9],p[6][9],p[7][9],p[8][9],p[9][9],p[5][2],p[5][3],p[6][1],p[6][2]});
		tests[13] = new OceanTestCase(buildFleet(new int[] {100, 290, 410, 220, 230, 240, 522, 707, 977}),new Position[] {p[0][0],p[0][1],p[0][2],p[0][3],p[1][1],p[2][0],p[3][0],p[4][0],p[5][0]});
		tests[14] = new OceanTestCase(buildFleet(new int[] {185, 373, 638, 459, 998, 5, 295, 609, 539, 856}),new Position[] {p[0][4],p[0][5],p[0][6],p[0][7],p[0][8],p[0][9],p[3][8],p[3][9],p[5][9],p[5][8],p[5][7],p[5][6],p[5][5],p[9][0],p[9][1],p[9][2],p[9][3],p[9][4],p[9][5],p[9][6],p[9][7],p[9][8],p[7][3]});
		tests[15] = new OceanTestCase(buildFleet(new int[] {109, 216, 306, 457, 677, 899, 898}),new Position[] {p[0][9],p[1][9],p[2][9],p[3][9],p[4][9],p[5][9],p[6][9],p[7][9],p[8][9],p[9][9],p[0][8],p[1][8],p[2][8],p[3][8],p[4][8],p[5][8],p[6][8],p[7][8],p[8][8],p[9][8],p[0][7],p[1][7],p[2][7],p[3][7],p[4][7],p[5][7],p[6][7],p[7][7],p[8][7],p[9][7],p[0][6],p[1][6],p[2][6],p[3][6],p[4][6],p[5][6],p[6][6],p[6][7]});
		tests[16] = new OceanTestCase(buildFleet(new int[] {104, 213, 223, 225, 403, 402, 406, 602, 602, 601, 901, 915, 935}),new Position[] {p[0][0],p[0][1],p[0][2],p[0][3],p[0][4],p[0][5],p[0][6],p[0][7],p[0][8],p[0][9],p[1][0],p[1][1],p[1][2],p[1][3],p[1][4],p[1][5],p[1][6],p[1][7],p[1][8],p[1][9],p[2][0],p[2][1],p[2][2],p[2][3],p[2][4],p[2][5],p[2][6],p[2][7],p[2][8],p[2][9],p[3][0],p[3][1],p[3][2],p[3][3],p[3][4],p[3][6],p[3][7],p[3][8],p[3][9],p[4][0],p[4][1],p[4][2],p[4][3],p[4][4],p[4][5],p[4][6],p[4][7],p[4][8],p[4][9],p[5][0],p[5][1],p[5][2],p[5][3],p[5][4],p[5][5],p[5][6],p[5][7],p[5][8],p[5][9],p[6][0],p[6][1],p[6][2],p[6][3],p[6][4],p[6][5],p[6][6],p[6][7],p[6][8],p[6][9],p[7][0],p[7][1],p[7][2],p[7][3],p[7][4],p[7][5],p[7][6],p[7][7],p[7][8],p[7][9],p[8][0],p[8][1],p[8][2],p[8][3],p[8][4],p[8][5],p[8][6],p[8][7],p[8][8],p[8][9],p[9][0],p[9][1],p[9][2],p[9][3],p[9][4],p[9][5],p[9][6],p[9][7],p[9][8],p[9][9],p[3][5]});
		tests[17] = new OceanTestCase(null,null);
		tests[18] = new OceanTestCase(null,null);
		tests[19] = new OceanTestCase(null,null);
		tests[20] = new OceanTestCase(null,null);
		tests[21] = new OceanTestCase(null,null);
		tests[22] = new OceanTestCase(null,null);
		tests[23] = new OceanTestCase(null,null);
		tests[24] = new OceanTestCase(null,null);
		tests[25] = new OceanTestCase(null,null);
		tests[26] = new OceanTestCase(null,null);
		tests[27] = new OceanTestCase(null,null);
		tests[28] = new OceanTestCase(null,null);
		tests[29] = new OceanTestCase(null,null);
		tests[30] = new OceanTestCase(null,null);
		tests[31] = new OceanTestCase(null,null);
		tests[32] = new OceanTestCase(null,null);
		tests[33] = new OceanTestCase(null,null);
		tests[34] = new OceanTestCase(null,null);
		tests[35] = new OceanTestCase(null,null);
		tests[36] = new OceanTestCase(null,null);
		tests[37] = new OceanTestCase(null,null);
		tests[38] = new OceanTestCase(null,null);
		tests[39] = new OceanTestCase(null,null);
		tests[40] = new OceanTestCase(null,null);
		return tests;
	}
	
	public static void main(String [] args)
	{
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		while(true){
			String nice = "buildFleet(new int[] {";
			for(int i=0;i<input.length();i+=5){
				String boat = input.substring(i,i+4);
				for(int x=0; x<boats.length;x++)
				{
					if(boats[x].equals(boat))
						nice = nice + x;
				}
				if(i!=input.length()-4)
					nice = nice + ", ";
			}
			nice = nice + "})";
			System.out.println(nice);
			input = scanner.nextLine();
		}
	}
	
	private Boat[] buildFleet(int[] indices)
	{
		Boat[] fleet = new Boat[indices.length];
		for(int x=0; x< indices.length;x++)
		{
			fleet[x] = buildBoat(boats[indices[x]]);
		}
		return fleet;
	}
	
	private Boat buildBoat(String s)
	{
		String names = "Cruiser.AircraftCarrier.Battleship.Submarine.Destroyer.";
		String orientations = "vertical.horizontal.";
		//This will build you literally ANY BOAT you want, just feed it the string from the above array
		return new Boat(names.substring(names.indexOf(s.substring(1,2)),names.indexOf(".",names.indexOf(s.substring(1,2)))),new Position(Integer.parseInt(s.substring(2,3)),Integer.parseInt(s.substring(3,4))),orientations.substring(orientations.indexOf(s.substring(0,1)),orientations.indexOf(".",orientations.indexOf(s.substring(0,1)))));
	}
}
