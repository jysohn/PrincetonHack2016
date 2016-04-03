import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Picture;
import java.util.Arrays;
import edu.princeton.cs.algs4.Knuth;

public class StarGazer {
    private class Constellation {
        private double[] starAngles;
        private String name;
        
        private Constellation(double[] starAngles, String name) {
            this.starAngles = starAngles;
            this.name = name;
        }
    }
    
    private double[] ursaMajorAngles = {0.2476833811684278, 0.354210511839996, 0.5171647286791881, 0.5269396193915875, 0.5934681713535223, 1.1106329000327466, 2.0597300242206957, 2.0619183132490044, 2.1262585761824937, 2.588857932640333, 5.082098686694866, 5.3297820678647465, 5.896258923172025, 6.003523252272352, 6.171115709093579, 6.25046943501322, 6.759608446092182, 8.395703439908093, 8.989171611261977, 9.199636002864041, 9.44731938403423, 9.506336339940331, 11.899782175444372, 12.253992687285464, 12.339496667960027, 12.425775450261485, 12.763131698364507, 14.465755244142805, 14.487693763510311, 14.529418070729072, 15.014633382901923, 15.032232099449914, 15.051540958094039, 15.405751469935124, 15.559171718841494, 15.888069981886527, 16.7172569286802, 17.621090032090446, 17.98807220996192, 18.659390621536534, 19.013601133377666, 20.04780223418241, 21.252277643957868, 21.302010393107157, 22.888372637773802, 23.305082611796472, 23.312007668178346, 24.283773421794574, 24.877241593148536, 25.173000059680145, 25.39440632182683, 27.30553364537953, 28.60101914341506, 30.04686548235182, 30.384348256102147, 30.605754518248848, 34.06514209147167, 34.37263606254428, 34.62031944371432, 34.772134852508685, 39.70241813040917, 41.300079878140274, 48.00226994357107, 48.742663887340655, 51.489391781188864, 73.17527000325123, 75.47858153473034, 76.21897547849993, 76.73614020717824, 77.3296083785322, 79.34841840558953, 82.37490600611537, 82.62258938728542, 85.72531181844028, 87.70468807398026, 101.61338180032679, 104.07960067814541, 105.86292979083251, 110.25071638723901, 115.74747652044663, 126.96797331591924, 128.0869731884066, 129.21760097984816, 130.21323176458938, 134.46394893424755, 138.09802622884857, 140.63506464334117, 141.64337643010953, 143.70529474335845, 144.23223436274998, 150.43834982982105, 152.5646084060039, 157.29681128121473, 157.3523215720214, 159.26446646220003, 159.35030387280645, 161.40310884064493, 161.4100338970268, 164.49014040778735, 164.90410507396396, 175.28488349117706, 176.82963707574712, 177.34461351539707, 178.9558956519284, 179.3981061069894};
    private Constellation ursaMajor = new Constellation(ursaMajorAngles, "Ursa Major");
    private double[] orionAngles = {0.155927529881304, 0.5007050843549133, 0.9109873280254849, 1.0371813813507207, 1.395697163123981, 1.4507439172157082, 1.6112572089309805, 2.287744410617984, 2.536809032349015, 2.565746102786846, 2.8185271710837565, 2.9108802151149056, 3.016062757146007, 3.1223821630151862, 3.592668085410176, 3.7485956152892896, 3.800523969709537, 3.899001619550258, 3.927050085171331, 4.3008064673733015, 4.45673399725252, 4.555634233784979, 4.5584142116612245, 4.643536364268774, 4.762821235953014, 5.157369879332247, 5.468652829833626, 5.59559559301171, 5.646251870511399, 5.728179039963622, 5.800002617303565, 5.883305997513743, 6.254793573201553, 6.554717944966697, 6.557239198536818, 7.590213316179728, 7.723115982118807, 8.04940208266277, 8.269809483936447, 8.542537983819365, 9.44677584022116, 9.573301955682767, 9.996494483827757, 10.357763168246567, 10.35841682896484, 10.375779446726622, 10.43894023129873, 10.885548919295742, 10.94739392148109, 11.826523363942428, 11.891019783553078, 12.046947313432225, 12.91334584820534, 13.126543823604846, 13.373825925392467, 13.45129502208243, 14.076582656465344, 14.524603057138034, 15.201233619137911, 15.211110426489208, 15.414288234222603, 15.639615398842514, 15.879800481341443, 16.10395848669019, 16.81234746775586, 17.025545443155327, 17.55470240390608, 18.59519665343856, 18.632216890250348, 18.72351188833693, 18.757147557405776, 19.011634396198865, 19.11806053171595, 19.250643978667796, 20.20789147462163, 20.435434715126487, 20.63130060143214, 20.882941064056244, 21.26132836602233, 21.669081807424213, 22.49419827298898, 22.712072283238218, 22.791446935317655, 23.071705480427642, 23.82707446880903, 24.51552288776405, 24.657886266710367, 25.18693483521709, 25.277818386024897, 25.56887359473576, 25.60851451277662, 26.95084500953373, 26.985432320459854, 27.09225340269102, 27.13773463725787, 27.248180932570186, 27.63011969208885, 27.846597942840443, 28.584936351881694, 28.667301073439443, 28.92972638532911, 29.769372180617584, 29.89631253557472, 29.938891291360722, 30.1669287244378, 30.279441379688045, 30.583670921348293, 30.84084901798042, 31.070240832730807, 31.20411010578841, 32.600664422387204, 33.43012230939253, 34.51201737159181, 35.08444964584744, 35.40754412119437, 35.96693134174151, 36.311849961311886, 36.60730248090376, 41.06673531655857, 41.46921984064402, 44.03496594343069, 44.796049992234025, 45.708944208796794, 46.57010983117739, 46.80287447451866, 46.81304349327295, 48.04778691704501, 48.38871807764425, 48.54464560752341, 48.61982442391166, 49.397501911404014, 49.81893723166457, 50.729924559689984, 51.27748305066688, 51.77818813502227, 51.851308401055, 52.845452074896784, 53.65919600122214, 54.06754091744891, 56.376176430201454, 56.39367603367028, 56.63328702023559, 57.75026839599974, 57.78937319679423, 59.01723364709532, 60.17670039991115, 60.43566539107652, 60.76633115314567, 61.484207759688005, 61.67731848117108, 61.79065689956772, 61.929005485158655, 62.13961581011054, 66.57254184942754, 67.32357035168255, 67.51883593953133, 68.18379905836022, 70.471543468978, 71.12409432139225, 71.4807022435158, 72.99422477774611, 73.55554215163723, 75.38781082640034, 75.60682983847421, 75.63689901021442, 76.4664223667521, 77.36400824102947, 77.75704601369922, 77.89461538625793, 78.2283280602006, 78.32722829673307, 78.51771005358907, 78.72903314455601, 78.72921200148943, 78.79422739504982, 79.34535930347378, 79.88049963808146, 81.04685523128448, 81.54756031563988, 81.6400922166043, 81.91964247481448, 83.35264160671099, 83.4731677234917, 83.59808729258286, 83.62909525337088, 86.33520474788146, 87.92990172074424, 89.06674012241652, 90.8048424495203, 91.33273170850072, 92.72842887162466, 93.00097851457407, 93.62336962060417, 94.39667567769803, 95.52011503692398, 95.94336431706817, 95.99622513127983, 98.1025068608796, 100.8688070201587, 102.55094307624658, 105.50314237404892, 106.42434708713866, 108.62552453706414, 108.96115611948763, 110.72134865606186, 119.80726827101907, 120.26245809382978, 120.5742146301379, 121.65815525695372, 123.40550687190749, 124.22665426238585, 124.57008950697218, 125.60727088832274, 126.22280569675623, 126.2240340429914, 127.3490364254011, 130.16568509998396, 132.550666797972, 135.79628883378484, 136.29699391814023, 137.74644564858482, 139.38051862554576, 140.65732586369964, 140.77621578866973, 142.65615085057524, 145.3408662284722, 145.47467802165914, 145.7871319846632, 149.12210490529492, 152.07325220522634, 153.17487905252509, 153.23739058041164, 155.04693281245267, 155.19563436824154, 155.54763789680806, 155.7741996127606, 156.5802499035947, 162.35301477984675, 162.83010817766004, 163.13496784856153, 167.64275818415942, 169.65996000523376, 171.05565716835787, 171.85169768080485, 172.34950926367455, 172.35240276516038, 172.4255230311928, 173.63372992750365, 174.27059261380128, 177.2115505050266, 178.0518312906241, 178.23281526118924};
    private Constellation orion = new Constellation(orionAngles, "Orion");
    private double[] leoAngles = {0.36750844152962625, 0.799124601300102, 0.9247666618196085, 1.475390515284218, 1.751373465383831, 1.7830573280594906, 3.1475464724219293, 3.2635127812353475, 4.550907622469573, 4.877370459144119, 4.930603800481228, 5.09730516352937, 5.103838028675037, 5.215650525626883, 5.329465653961304, 5.676323388976704, 6.222720930036463, 6.804288339080032, 6.843583555162546, 6.983335412403939, 7.027605778007839, 7.080839119345008, 7.3508438539337115, 7.729055000899302, 8.244851635951358, 8.27856390062376, 8.423778785046045, 8.688705674201746, 9.161698994228688, 9.384922743389556, 9.568832170547852, 9.596665030702642, 9.75395441590761, 9.870160027765252, 9.87962077048846, 10.027908964010686, 10.291118559243163, 10.944175227356432, 10.944756322287914, 11.019443261286472, 11.072055545986517, 11.534243034873557, 11.681658798224113, 11.901751476403367, 12.519906944139292, 12.606425460043459, 12.703929166984507, 12.849450643087863, 13.375869064153212, 13.70216022935979, 13.825989555324098, 14.092302794709878, 14.851259579437151, 15.153887214033936, 15.297356872277389, 15.577363020707947, 15.7562901698025, 15.96744194821976, 16.325879936316337, 16.523415536575158, 16.975018175962052, 17.347886296944033, 17.602147302784466, 17.741899160025838, 17.99880605185905, 18.147010898244478, 18.253067851829382, 18.303399555534458, 18.306472864634483, 18.526913964603853, 19.189607958239343, 19.350619446610303, 19.54751272214717, 19.78186337991837, 20.588275431834298, 20.906828674669143, 21.429717964991443, 21.740715702263365, 21.979011099839056, 22.026010698804345, 22.23437338647734, 22.811025503382346, 23.696149583089333, 23.868893904374282, 24.44792461013972, 24.88439596437571, 25.024047241799167, 25.23640326423335, 25.312650819037973, 25.33120230368385, 25.44752304847318, 25.580613033563456, 25.603911705763128, 27.46817185886315, 27.595471082561673, 27.757193106786428, 28.943562374147064, 29.37852841062097, 30.208572762827924, 30.347924577933245, 30.42942137646509, 30.528301344664886, 30.677178405321854, 30.776988702434387, 32.65647954677585, 33.2538166477638, 33.43772607492214, 34.60077666194903, 35.228086027791456, 37.77325010420297, 38.54022740484967, 38.701368334142856, 38.85003679712325, 40.07843332827506, 40.27710005092566, 40.60141026250709, 42.21142144019539, 42.5789298817252, 42.82264881831166, 42.914798121822464, 43.83956478364183, 45.54495188930545, 45.930875916468324, 47.3047058289336, 47.69581087487733, 48.13044864744937, 48.494935476177766, 49.05521530926874, 49.46335607166459, 49.8911184080305, 50.39837870680168, 50.5682186101688, 50.6438531227218, 51.2212752782821, 51.890241130559524, 53.07060697648034, 55.521223581865904, 55.81481201576371, 55.85950364834872, 55.928537611496736, 56.40431326459143, 56.87994756756322, 57.02853286136743, 57.1058916561864, 57.24745600909302, 58.24888105629, 59.770739178518994, 60.29204564260265, 60.736874107492824, 61.50815129326653, 61.51239383752521, 62.31280671475242, 63.35386313776643, 64.21524261439521, 64.23079142149695, 65.78923600798095, 67.31965142061053, 68.19451796356499, 68.78169904396658, 70.89307403665603, 71.63183411029385, 72.99597480958717, 73.27642390844076, 73.33224997603888, 73.59158688316975, 74.07554850974124, 76.36117441335087, 78.6386866510688, 78.65122001004382, 79.36912982842915, 79.83955836474978, 80.32053978449564, 81.51145488078231, 82.41854247522438, 82.48385927332636, 82.90108214658672, 83.74252467974385, 84.38629517296913, 85.04988008755265, 85.18541977426963, 89.23928985619438, 89.65812991235525, 89.93523366582833, 90.20016055498408, 91.33348604319559, 92.91850833008671, 93.70178771569971, 94.76196794103032, 95.24162561008924, 96.2281190157271, 98.3871851121552, 98.4759828475455, 98.6239393400301, 99.1412292601232, 99.22696208290309, 99.45887744928844, 100.02068977800889, 100.94545643982823, 102.53330607121366, 103.0652794115185, 104.33080011157818, 104.81665287690232, 106.79059578981595, 107.075890786357, 107.59675147153622, 107.74974477890824, 108.99914458797709, 110.14611853086353, 111.04967401264372, 111.84879861394423, 111.98440918552961, 112.6271152380523, 114.89751942992577, 116.21788200757132, 117.80290429446248, 118.20713011556617, 118.54092669889262, 120.0300546301589, 123.98996558997146, 124.02562522449892, 126.34703088492114, 127.14615548622159, 128.8166064886203, 128.88459856250293, 132.88123064914694, 135.18394184419282, 139.78191539430154, 144.64088873230548, 145.05410187195812, 146.62649772252874, 148.46754934080928, 148.8743615543471, 150.863609662342, 152.1215731776525, 152.4890816191823, 156.6817141978465, 158.46184368271034, 158.88009142728222, 159.47241703158625, 160.63146489266603, 162.38278789233127, 162.98887554781467, 163.76490621308662, 164.02332465405593, 165.2994969406223, 165.96093054662725, 166.56133496833493, 168.60550882236785, 171.41265433286065, 174.98511375338083, 177.72548488341522, 178.7077248966499};
    private Constellation leo = new Constellation(leoAngles, "Leo");
    private double[] cygnusAngles = {0.3697880241352172, 0.7041591081242399, 0.766950589845039, 0.827714570711298, 0.8393126669676122, 0.9019821760611441, 1.1019966253319537, 1.198718289151488, 1.2276105160598703, 1.2370282115485705, 1.321765804919313, 1.4697648243891634, 1.5053041881613352, 1.8933967071938642, 2.1295926921204162, 2.70402247731285, 2.8410696537637845, 3.2108576778968128, 3.7586874348754367, 4.150148133514458, 5.436731851474501, 5.605301421732947, 5.82495864765076, 5.942372685769, 6.076364025985938, 6.287058679153951, 6.605633478488053, 6.748048533503, 6.7672009274481475, 7.02541710734638, 7.044369311100957, 7.294723472039795, 7.567763441795096, 7.587361200470767, 7.594915498159008, 7.707630103820146, 7.792367697191062, 7.8995444762094085, 8.088966732367608, 8.79537395785451, 8.916681303078557, 9.363988856608417, 9.697356133915775, 11.158689928568192, 12.476244084066815, 12.56500751873503, 12.858244083899306, 12.990722429358517, 13.280185346091013, 13.6500027895891, 13.798009888986362, 14.107899916801838, 14.563309523521148, 16.857048019739025, 16.950900768325205, 17.008392217413732, 17.86851854943676, 18.09407623128773, 18.57267765756093, 18.80061676966826, 19.31790774458744, 19.90261339500041, 20.565210816434433, 20.84401268878344, 20.875100844250007, 21.10104890183962, 21.16894300200911, 21.191075406790965, 21.39292538714535, 22.19686664916956, 22.27093962734127, 22.950764903182737, 23.104031947036702, 24.052761528514857, 24.438875274659182, 25.137923855166303, 25.26658984537011, 26.282253359940107, 26.324703660371004, 26.33664214431816, 26.343324851933808, 26.508246873488417, 26.627417951574675, 26.714623294362234, 27.02886276849522, 27.091654250215658, 27.110275441778434, 27.61660547042344, 27.647414621697205, 27.795813358339906, 27.841946332479125, 28.21331231311022, 28.844215986482833, 29.152718809858246, 30.351437099010035, 30.658395007002866, 30.743225276899285, 31.941943566051094, 32.033790772818165, 32.34976533535917, 32.703781977560574, 33.35555657773776, 33.4472477542121, 33.95929298573903, 34.11707135756201, 34.50191271177471, 34.67311073323628, 34.821230465686256, 35.70063100092651, 36.411979428277974, 36.88064537361409, 36.96097534032748, 37.20593518908749, 38.16337839851937, 38.35041019800313, 39.901665671507914, 40.63813705105573, 41.00366229684004, 41.07155639700954, 41.20359051378158, 42.14344123921676, 42.78593398797831, 43.34215952836856, 44.17536884565393, 44.25569881236732, 44.89738131793199, 45.22170453052397, 45.62995068145014, 45.66433190777665, 45.73114184031449, 45.831800661804536, 46.45766525216105, 46.95875235637392, 47.402643135235095, 47.609295775328036, 47.77243115936815, 47.86073453243512, 47.95163904728461, 48.7909517142525, 50.61350081313197, 50.62170001181558, 51.461012678783504, 52.03627127444361, 52.68974901512301, 52.83937498670956, 53.20916301084261, 53.22486617960915, 53.434979102149434, 54.139138210273686, 54.5466319845287, 55.489360954176355, 56.05023266460643, 57.47300312591805, 58.209061212286535, 59.93581575065297, 60.06500728736416, 61.094662375909316, 62.047603202565, 62.17260529884917, 64.44563175845948, 64.85334981078474, 65.37254760212743, 65.889965935015, 66.81621718281166, 67.02287606859548, 67.359730759404, 68.05324539436035, 68.48008338353488, 68.79565173606804, 69.63496440303595, 72.00765675971047, 72.0133952002546, 73.24100571631404, 74.08538480526784, 74.14298789237523, 74.57535782679733, 77.24911796339026, 77.84407224014325, 78.08843063035818, 80.33919017804818, 81.1363441859814, 82.2325868852419, 82.90492620092314, 83.32548198937613, 84.16479465634407, 84.79832290811687, 84.83647916386121, 84.91029341409937, 90.91284318984708, 92.90419769678323, 94.79759440397694, 97.38718598100058, 99.41265172606812, 99.76197422066217, 99.93760294627589, 100.85761118673747, 100.99900243221086, 101.65537092785591, 102.89239913940459, 104.24037613301812, 104.87564626115316, 105.24543428528621, 106.22466162542992, 108.08650393905002, 109.9521934997356, 112.77519073736251, 113.14497876149558, 115.98604841525938, 116.6654833539923, 120.25666441485154, 124.48287657798028, 124.56502783020166, 126.04006967764279, 127.3484682307483, 130.18953788451216, 130.55932590864518, 132.11643370362867, 134.65951223528228, 136.81824831988996, 138.28801314427898, 142.2820195793856, 143.105306999044, 144.11297179192977, 144.575071823433, 145.71032366090392, 146.88408236642618, 149.534962241552, 150.40003047108385, 151.19749987234246, 152.09948204840364, 152.96044639241205, 153.32709256446313, 155.8220209207061, 160.1505381288224, 160.85469723694672, 160.89485600625818, 160.9417655952224, 164.2034031638122, 165.02823140549145, 165.13751308616503, 165.44043137536087, 167.81521961502247, 169.70861632221647, 172.0536485128381, 172.63899418858858, 172.8205991026824, 176.6012991046446, 176.76841068254754, 177.70252060489997, 177.9619690438806, 178.00543889409568, 178.92605286774227};
    private Constellation cygnus = new Constellation(cygnusAngles, "Cygnus");
    private double[] cancerAngles = {1.0270418395139542, 1.6527437286189586, 2.516252188844429, 3.5035111570973787, 4.205222283034458, 5.151419638873056, 7.706713244208261, 7.936739496227887, 8.381283509116223, 9.082994635053238, 9.565615234382907, 9.589483224846985, 11.58015249362072, 12.564822002840845, 14.096404682465032, 14.120036221458205, 15.081074191685104, 15.994348089130668, 16.31802300534414, 16.770044285875258, 17.272328478591227, 17.970766733963128, 19.28629647471952, 20.665387606717676, 23.203030856511436, 26.661226685305856, 29.31548846561138, 30.866448968340286, 32.818999622708795, 37.80743406381171, 39.460177792430684, 45.309836554742056, 47.39691728865862, 48.813347711839455, 55.41763414857593, 55.77820079777484, 57.445779831015535, 63.12434739278422, 66.10954418089469, 67.13658602040853, 71.56581605247374, 72.68996262716718, 76.08302175529363, 80.64881068752696, 83.78973499950193, 93.35535023388488, 119.87443460085164, 136.56447531293043, 137.5915171524443, 141.71589495180348, 142.74293679131736, 151.14751902778804, 154.84867220500854, 156.29893866666106, 156.33798008315208, 158.35218336210593, 159.47675471162142, 168.55974934667478, 172.33232817228279, 177.32021443186719};
    private Constellation cancer = new Constellation(cancerAngles, "Cancer");
    private Constellation[] constellations = {ursaMajor, orion, leo, cygnus, cancer};
    
    private double TAU = 150.0;
    private int P = 8;
    
    public StarGazer() {
        Knuth.shuffle(constellations);
        int constellationsCorrect = 0;
        for (int i = 0; i < constellations.length; i++) {
            StdOut.print("Please capture: " + constellations[i].name);
            //READ IN PICTURE
            Picture picture = new Picture("userinput.jpg");
            StarFinder starFinder = new StarFinder(picture, TAU);
            ConstellationFinder constellationFinder = new ConstellationFinder(starFinder.getStars(P));
            Constellation user = new Constellation(constellationFinder.getStarAngles(), "User");
            int anglesCorrect = 0;
            for (int j = 0; j < constellations[i].starAngles.length; j = j + 3) {
                if (closeEnough(user.starAngles, constellations[i].starAngles[j])) anglesCorrect++;
            }
            if (anglesCorrect/constellations[i].starAngles.length * 3 > .75) {
                constellationsCorrect++;
            }
            
        }
        StdOut.print("Your final score: " + constellationsCorrect + "/" + constellations.length);
    }
    
     private boolean closeEnough(double[] a, double key) {
        if (key - floorSearch(a, 0, a.length-1, key) < 2) return true;
        if (ceilSearch(a, 0, a.length-1, key) - key < 2) return true;
        else return false;
    }
     
    private double floorSearch(double a[], int low, int high, double x)
    {
        if (low > high) {
            return low;
        }
        
        int mid = (low + high) / 2;
        if (a[mid] > x) {
            return floorSearch(a, low, mid - 1, x);
        }
        else if (a[mid] < x){
            return floorSearch(a, mid + 1, high, x);
        }
        else {
            return mid;
        }
        
    }
    
    private double ceilSearch(double a[], int low, int high, double x)
    {
        if (low > high){
            return high;
        }
        int mid = (low + high) / 2;
        if (a[mid] > x){
            return ceilSearch(a, low, mid - 1, x);
        }
        else if (a[mid] < x){
            return ceilSearch(a, mid + 1, high, x);
        }
        else {
            return mid;
        }
    }
    
   
}